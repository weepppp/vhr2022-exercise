package com.qfedu.vhr.employee.config;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import com.qfedu.vhr.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weepppp 2022/7/30 8:49
 **/
@Component
public class DoloadConfig {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    EmployeeDoToVoConfig employeeDoToVoConfig;

    public List<EmployeeVo> getAllEmployeeVo() {
        List<Employee> employees = employeeService.list();
        List<EmployeeVo> employeeVos = employees.stream().map(employee -> {
            return employeeDoToVoConfig.getEmployeeVo(employee);
        }).collect(Collectors.toList());
        return employeeVos;
    }
}
