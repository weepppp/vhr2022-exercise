package com.qfedu.vhr.employee.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qf
 * @since 2022-07-29
 */
public interface EmployeeMapper extends BaseMapper<Employee> {


//    List<EmployeeVo> getAllEmployees(Page<EmployeeVo> p);

    Page<Employee> getEmployeeByPage(Page<Employee> p);

}
