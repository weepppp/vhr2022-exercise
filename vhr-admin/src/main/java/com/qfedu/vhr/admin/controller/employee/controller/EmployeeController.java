package com.qfedu.vhr.admin.controller.employee.controller;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.service.IEmployeeService;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author weepppp 2022/7/29 12:39
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getAllEmployees(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getAllEmployees(page, size);
    }

    @PostMapping("/")
    public RespBean addEmployees(@RequestBody Employee employee) {
        return employeeService.addEmployees(employee);
    }
}
