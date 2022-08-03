package com.qfedu.vhr.employee.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.qfedu.vhr.employee.config.EmployeeDoToVoConfig;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import com.qfedu.vhr.employee.service.IEmployeeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author weepppp 2022/7/30 8:44
 **/
public class EmployeeListener implements ReadListener<EmployeeVo> {

    EmployeeDoToVoConfig employeeDoToVoConfig = new EmployeeDoToVoConfig();

    private IEmployeeService employeeService;

    public EmployeeListener(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private List<Employee> employees = new ArrayList<>();


    @Override
    public void invoke(EmployeeVo employeevo, AnalysisContext analysisContext) {
        employeevo.setId(null);
        Employee employee = employeeDoToVoConfig.getEmployee(employeevo);
        System.out.println(employee.toString());
        employees.add(employee);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        employeeService.saveBatch(employees);
    }


}
