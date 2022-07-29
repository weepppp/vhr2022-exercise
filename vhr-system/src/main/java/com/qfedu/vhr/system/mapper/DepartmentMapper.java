package com.qfedu.vhr.system.mapper;

import com.qfedu.vhr.system.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.system.entity.vo.AddDepartmentVo;
import com.qfedu.vhr.system.entity.vo.DepartmentChildrenVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<DepartmentChildrenVo> getAllDepts(int pid);

    void addDepartment(AddDepartmentVo department);

    void deleteDepartmentById(AddDepartmentVo addDepartmentVo);

}
