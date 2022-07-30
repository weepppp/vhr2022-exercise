package com.qfedu.vhr.employee.config;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.Nation;
import com.qfedu.vhr.employee.entity.Politicsstatus;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import com.qfedu.vhr.employee.mapper.NationMapper;
import com.qfedu.vhr.employee.mapper.PoliticsstatusMapper;
import com.qfedu.vhr.system.entity.Department;
import com.qfedu.vhr.system.entity.Joblevel;
import com.qfedu.vhr.system.entity.Position;
import com.qfedu.vhr.system.mapper.DepartmentMapper;
import com.qfedu.vhr.system.mapper.JoblevelMapper;
import com.qfedu.vhr.system.mapper.PositionMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weepppp 2022/7/30 9:17
 **/
@Component
public class EmployeeDoToVoConfig {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    JoblevelMapper joblevelMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    NationMapper nationMapper;
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public EmployeeVo getEmployeeVo(Employee employee) {
        EmployeeVo employeeVo = new EmployeeVo();
        employeeVo = EmployeeDoToVo.INSTANCE.employDO2VO(employee);
        Department department = departmentMapper.selectById(employee.getDepartmentId());
        employeeVo.setDepartmentId(department.getName());
        Joblevel joblevel = joblevelMapper.selectById(employee.getJobLevelId());
        employeeVo.setJobLevelId(joblevel.getName());
        Position position = positionMapper.selectById(employee.getPosId());
        employeeVo.setPosId(position.getName());
        Politicsstatus politicsstatus = politicsstatusMapper.selectById(employee.getPoliticId());
        employeeVo.setPoliticId(politicsstatus.getName());
        Nation nation = nationMapper.selectById(employee.getNationId());
        employeeVo.setNationId(nation.getName());
        return employeeVo;
    }
}
