package com.qfedu.vhr.employee.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.service.IEmployeeService;
import com.qfedu.vhr.system.entity.Position;
import com.qfedu.vhr.system.service.IPositionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author weepppp 2022/7/30 8:44
 **/
public class EmployeeListener implements ReadListener<Employee> {
    public EmployeeListener(IEmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    private List<Employee> employees = new ArrayList<>();
    private IEmployeeService employeeService;

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {

    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {

    }

    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        employee.setId(null);
        employees.add(employee);
    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        employeeService.saveBatch(employees);
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return false;
    }
}
