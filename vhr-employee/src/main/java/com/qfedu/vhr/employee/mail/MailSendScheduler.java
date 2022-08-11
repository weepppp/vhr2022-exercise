package com.qfedu.vhr.employee.mail;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.MailSendLog;
import com.qfedu.vhr.employee.service.IEmployeeService;
import com.qfedu.vhr.employee.service.IMailSendLogService;
import com.qfedu.vhr.framework.entity.vo.EmployeeDTO;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author weepppp 2022/8/11 19:31
 *
 * 邮件发送是耗时操作、发送短信也是耗时操作，耗时操作会阻塞当前线程，所以一般如果不使用中间件，耗时操作一般要放在子线程中去完成。
 *
 * 以发邮件为例：
 *
 * 1. 项目中，需要发邮件的地方比较多。
 * 2. 邮件发送可能会失败，发送失败需要重试，而在子线程中进行重试会比较复杂。
 *
 * 可以搭建一个邮件服务器：
 *
 * 1. 所谓的邮件服务器，就是一个专门的 Spring Boot 项目，解耦。
 * 2. 项目中，任何需要发送邮件的地方，都给 RabbitMQ 扔一条消息，扔完就完事。
 * 3. 邮件服务器专门去消费 MQ 中的消息，收到消息之后，自动发送一封邮件出去。
 *
 *
 *
 * 需求：当 Hr 录入员工信息的时候，录入成功之后，就自动发送一封入职欢迎邮件给员工。
 *
 * 1. 在添加员工的时候，三件事：
 *    1. 首先将员工的数据存入到数据库中。
 *    2. 将发给消息中间件的信息记录到数据库中：交换机的名字、队列的名字、员工的 id 等其他信息，也存入到数据库中，同时设置 status 为 0 表示消息发送中，重试次数为 0，再设置第一次重试时间等。
 *    3. 给消息中间件发送一条消息。
 * 2. 在 RabbitTemplate 中，配置两个回调（这里配置一个回调也行，因为只要代码正确，消息到达交换机之后，就一定能到队列）：
 *    1. 如果消息到达交换机，就认为消息发送成功，此时将 01-b 中的记录的 status 改为 1。
 * 3. 开启一个定时任务：定时任务每隔 10s 秒，就去数据库捞一下 status 为 0 并且已经超过第一次重试时间的记录，拿出来检查重试次数是否已经达到最大次数，如果达到了，直接设置 status 为 2，发送失败，如果没达到，就去重试。
 **/
@Component
public class MailSendScheduler {

    @Autowired
    IMailSendLogService mailSendLogService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    IEmployeeService employeeService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void mailSchedule(){
        QueryWrapper<MailSendLog> qw = new QueryWrapper<>();
        qw.lambda().eq(MailSendLog::getStatus,0).le(MailSendLog::getTryTime,new Date());
        List<MailSendLog> list = mailSendLogService.list(qw);
        for (MailSendLog mailSendLog : list){
            if (mailSendLog.getCount() > 2){
                MailSendLog mailSendLog1 = new MailSendLog();
                mailSendLog1.setStatus(2);
                mailSendLogService.updateById(mailSendLog1);
            } else {
                Employee employee = employeeService.getById(mailSendLog.getEmpId());
                mailSendLog.setCount(mailSendLog.getCount()+1);
                mailSendLogService.updateById(mailSendLog);
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(employee.getId());
                employeeDTO.setEmail(employee.getEmail());
                employeeDTO.setName(employee.getName());
                rabbitTemplate.convertAndSend(mailSendLog.getExchange(),mailSendLog.getRouteKey(),employeeDTO,
                        new CorrelationData(mailSendLog.getMsgId()));
            }
        }

    }
}
