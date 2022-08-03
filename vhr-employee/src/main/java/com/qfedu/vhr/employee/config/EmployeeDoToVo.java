package com.qfedu.vhr.employee.config;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author weepppp 2022/7/30 0:03
 **/
@Mapper
public interface EmployeeDoToVo {
    EmployeeDoToVo INSTANCE  = Mappers.getMapper(EmployeeDoToVo.class);

    @Mapping(target = "nationId",ignore = true)
    @Mapping(target = "politicId",ignore = true)
    @Mapping(target = "departmentId",ignore = true)
    @Mapping(target = "jobLevelId",ignore = true)
    @Mapping(target = "posId",ignore = true)
    EmployeeVo employDO2VO(Employee employee);

    @Mapping(target = "nationId",ignore = true)
    @Mapping(target = "politicId",ignore = true)
    @Mapping(target = "departmentId",ignore = true)
    @Mapping(target = "jobLevelId",ignore = true)
    @Mapping(target = "posId",ignore = true)
    Employee employVO2DO(EmployeeVo employeeVo);
}
