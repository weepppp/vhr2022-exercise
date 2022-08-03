package com.qfedu.vhr.admin.controller.employee.controller;

import com.alibaba.excel.EasyExcel;
import com.qfedu.vhr.employee.config.DoloadConfig;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import com.qfedu.vhr.employee.service.IEmployeeService;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author weepppp 2022/7/29 12:39
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;
    @Autowired
    DoloadConfig doloadConfig;

    @GetMapping("/")
    public RespPageBean getAllEmployees(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getAllEmployees(page, size);
    }

    @PostMapping("/")
    public RespBean addEmployees(@RequestBody Employee employee) {
        return employeeService.addEmployees(employee);
    }

    @GetMapping("/export")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("员工信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+".xlsx");
        EasyExcel.write(response.getOutputStream(), EmployeeVo.class).sheet("职位信息").doWrite(doloadConfig.getAllEmployeeVo());
    }

    @PostMapping("/import")
    public RespBean importPositionData(MultipartFile file){
        return employeeService.importPositionData(file);
    }
}
