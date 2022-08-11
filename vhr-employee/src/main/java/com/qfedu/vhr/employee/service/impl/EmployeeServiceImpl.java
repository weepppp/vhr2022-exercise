package com.qfedu.vhr.employee.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.MailSendLog;
import com.qfedu.vhr.employee.mapper.EmployeeMapper;
import com.qfedu.vhr.employee.service.IEmployeeService;
import com.qfedu.vhr.employee.service.IMailSendLogService;
import com.qfedu.vhr.framework.config.MailSendConfig;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import com.qfedu.vhr.framework.entity.vo.EmployeeDTO;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qf
 * @since 2022-07-29
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

//    @Autowired
//    EmployeeMapper employeeMapper;
//    @Autowired
//    EmployeeDoToVoConfig employeeDoToVoConfig;
//
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    IMailSendLogService mailSendLogService;

    @Override
    public RespPageBean getAllEmployees(Integer page, Integer size) {
        Page<Employee> p = new Page<>(page, size);
//        Page<EmployeeVo> pvo = new Page<>(page, size);
//        Page<Employee> employeePage = employeeMapper.selectPage(p, null);
//        List<Employee> employees = employeePage.getRecords();
//        List<EmployeeVo> employeeVos = employees.stream().map(employee -> {
//            return employeeDoToVoConfig.getEmployeeVo(employee);
//        }).collect(Collectors.toList());
//        pvo.setRecords(employeeVos);
//        pvo.setTotal(employeePage.getTotal());
//        pvo.setCurrent(employeePage.getCurrent());
//        pvo.setPages(employeePage.getPages());
//        pvo.setSize(employeePage.getSize());
//        Page<Employee> employeePage =  employeeMapper.getEmployeeByPage(p);
        return new RespPageBean();
    }



    @Override
    public RespBean addEmployees(Employee employee) {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.lambda().eq(Employee::getName, employee.getName());
        Employee e = getOne(qw);
        if (e != null) {
            return RespBean.error("输入的用户已存在，添加失败");
        }
        if (save(employee)) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @Override
    public RespBean importPositionData(MultipartFile file) {
//        try {
////            EasyExcel.read(file.getInputStream(), EmployeeVo.class,new EmployeeListener(this)).sheet().doRead();
//            return RespBean.ok("导入成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return RespBean.error("导入失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMailEmployees(Employee employee) {
        save(employee);
        MailSendLog mailSendLog = new MailSendLog();
        String msgId = UUID.randomUUID().toString();
        mailSendLog.setMsgId(msgId);
        mailSendLog.setExchange(MailSendConfig.MAIL_SEND_EXCHANGE_NAME);
        mailSendLog.setRouteKey(MailSendConfig.MAIL_SEND_QUEUE_NAME);
        mailSendLog.setTryTime(LocalDateTime.ofInstant(new Date(System.currentTimeMillis()+60*1000).toInstant(), ZoneId.of("Asia/Shanghai")));
        mailSendLog.setStatus(0);
        mailSendLog.setCreateTime(LocalDateTime.now());
        mailSendLog.setCount(0);
        mailSendLog.setEmpId(employee.getId());
        mailSendLogService.save(mailSendLog);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setName(employee.getName());
        rabbitTemplate.convertAndSend(MailSendConfig.MAIL_SEND_EXCHANGE_NAME,MailSendConfig.MAIL_SEND_QUEUE_NAME,employeeDTO,new CorrelationData(msgId));

    }
}
