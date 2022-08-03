package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.qfedu.vhr.admin.controller.system.entity.vo.AddDepartmentVo;
import com.qfedu.vhr.admin.controller.system.entity.vo.DepartmentChildrenVo;
import com.qfedu.vhr.admin.controller.system.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<DepartmentChildrenVo> getAllDepts(){
        List<DepartmentChildrenVo> departmentChildrenVos = departmentService.getAllDepts();
        return departmentChildrenVos;
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody AddDepartmentVo department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/list")
    public List<Department> getAllDepartments(){
        return departmentService.list();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepartmentById(@PathVariable Integer id){
        return departmentService.deleteDepartmentById(id);
    }
}
