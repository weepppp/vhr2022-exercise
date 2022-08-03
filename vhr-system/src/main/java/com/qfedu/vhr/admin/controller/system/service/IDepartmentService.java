package com.qfedu.vhr.admin.controller.system.service;

import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.vhr.admin.controller.system.entity.vo.AddDepartmentVo;
import com.qfedu.vhr.admin.controller.system.entity.vo.DepartmentChildrenVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
public interface IDepartmentService extends IService<Department> {

    List<DepartmentChildrenVo> getAllDepts();

    RespBean addDepartment(AddDepartmentVo department);

    RespBean deleteDepartmentById(Integer id);

}
