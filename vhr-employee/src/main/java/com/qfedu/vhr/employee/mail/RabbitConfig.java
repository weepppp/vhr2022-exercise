package com.qfedu.vhr.employee.mail;

import com.qfedu.vhr.employee.entity.MailSendLog;
import com.qfedu.vhr.employee.service.IMailSendLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author weepppp 2022/8/11 19:26
 **/
@Configuration
public class RabbitConfig implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    IMailSendLogService mailSendLogService;

    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b){
            String id = correlationData.getId();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(id);
            mailSendLog.setStatus(1);
            mailSendLogService.updateById(mailSendLog);
        }
    }
}
