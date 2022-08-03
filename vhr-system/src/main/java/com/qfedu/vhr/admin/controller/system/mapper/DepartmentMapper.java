package com.qfedu.vhr.admin.controller.system.mapper;

import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.admin.controller.system.entity.vo.AddDepartmentVo;
import com.qfedu.vhr.admin.controller.system.entity.vo.DepartmentChildrenVo;
import org.apache.ibatis.annotations.Param;

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

    Department selectByDepartmentName(@Param("name") String departmentId);

}
