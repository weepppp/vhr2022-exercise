package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.system.entity.vo.DepartMentVo;
import com.qfedu.vhr.system.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weepppp 2022/7/28 14:31
 **/
@RestController
@RequestMapping("/system/basic/department")
public class DepartMentController {

    @Autowired
    IDepartmentService departmentService;

    @GetMapping("/")
    public List<DepartMentVo> getAllDepts(){
        List<DepartMentVo> departMentVos = departmentService.getAllDepts();
        return departMentVos;
    }
}
