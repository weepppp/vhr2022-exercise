package com.qfedu.vhr.admin.controller.system.service.impl;

import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.qfedu.vhr.admin.controller.system.entity.vo.AddDepartmentVo;
import com.qfedu.vhr.admin.controller.system.entity.vo.DepartmentChildrenVo;
import com.qfedu.vhr.admin.controller.system.mapper.DepartmentMapper;
import com.qfedu.vhr.admin.controller.system.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentChildrenVo> getAllDepts() {
        return departmentMapper.getAllDepts(-1);
    }

    @Override
    public RespBean addDepartment(AddDepartmentVo department) {
        department.setEnabled(true);
        department.setIsParent(false);
        departmentMapper.addDepartment(department);
        if (department.getResult() == 1) {
            return RespBean.ok("添加成功", department);
        }
        return RespBean.error("添加失败");
    }

    @Override
    public RespBean deleteDepartmentById(Integer id) {
        AddDepartmentVo addDepartmentVo = new AddDepartmentVo();
        addDepartmentVo.setId(id);
        departmentMapper.deleteDepartmentById(addDepartmentVo);
        if(addDepartmentVo.getResult()==-2){
            return RespBean.error("该部门下有子部门或者该部门不存在，删除失败");
        } else if(addDepartmentVo.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if(addDepartmentVo.getResult()==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
