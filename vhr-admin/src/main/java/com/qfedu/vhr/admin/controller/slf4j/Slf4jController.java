package com.qfedu.vhr.admin.controller.slf4j;

import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.qfedu.vhr.admin.controller.system.mapper.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weepppp 2022/7/30 15:29
 **/
@RestController
@Slf4j
public class Slf4jController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/log")
    public void getLog() {
        log.trace("我是trace");
        log.debug("我是debug");
        log.info("我是info");
        log.warn("我是warn");
        log.error("我是error");
    }

    @GetMapping("/mapper")
    public void getMapper(String name) {
        Department department = departmentMapper.selectByDepartmentName(name);
        System.out.println(department.toString());
    }
}
