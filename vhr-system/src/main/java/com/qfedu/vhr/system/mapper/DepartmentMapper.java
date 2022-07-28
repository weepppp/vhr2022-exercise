package com.qfedu.vhr.system.mapper;

import com.qfedu.vhr.system.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.system.entity.vo.DepartMentVo;

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

    List<DepartMentVo> getAllDepts(int pid);

}
