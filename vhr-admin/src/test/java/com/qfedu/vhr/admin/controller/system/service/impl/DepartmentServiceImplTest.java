package com.qfedu.vhr.admin.controller.system.service.impl;

import com.qfedu.vhr.VhrApp;
import com.qfedu.vhr.admin.controller.system.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


/**
 * @author weepppp 2022/8/3 12:38
 * service单元测试1
 **/
@SpringBootTest(classes = VhrApp.class)
public class DepartmentServiceImplTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void getAllDepts() {
        System.out.println(departmentMapper.getAllDepts(-1));
//       Assert.isNull(departmentMapper.getAllDepts(-1));
    }
}