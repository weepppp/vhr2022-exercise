package com.qfedu.vhr.employee.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.Nation;
import com.qfedu.vhr.employee.entity.Politicsstatus;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import com.qfedu.vhr.employee.mapper.NationMapper;
import com.qfedu.vhr.employee.mapper.PoliticsstatusMapper;
import com.qfedu.vhr.admin.controller.system.entity.Department;
import com.qfedu.vhr.admin.controller.system.entity.Joblevel;
import com.qfedu.vhr.admin.controller.system.entity.Position;
import com.qfedu.vhr.admin.controller.system.mapper.DepartmentMapper;
import com.qfedu.vhr.admin.controller.system.mapper.JoblevelMapper;
import com.qfedu.vhr.admin.controller.system.mapper.PositionMapper;
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

    public Employee getEmployee(EmployeeVo employeeVo){
        Employee employee = new Employee();
        employee = EmployeeDoToVo.INSTANCE.employVO2DO(employeeVo);
        String name = employeeVo.getDepartmentId();
        Department department = departmentMapper.selectByDepartmentName(name);
        System.out.println(department.toString());
        employee.setDepartmentId(department.getId());
        QueryWrapper<Joblevel> eq2 = new QueryWrapper<Joblevel>().eq("name", employeeVo.getJobLevelId());
        Joblevel joblevel = joblevelMapper.selectOne(eq2);
        employee.setJobLevelId(joblevel.getId());
        QueryWrapper<Position> eq3 = new QueryWrapper<Position>().eq("name", employeeVo.getPosId());
        Position position = positionMapper.selectOne(eq3);
        employee.setPosId(position.getId());
        QueryWrapper<Politicsstatus> eq4 = new QueryWrapper<Politicsstatus>().eq("name", employeeVo.getPoliticId());
        Politicsstatus politicsstatus = politicsstatusMapper.selectOne(eq4);
        employee.setPoliticId(politicsstatus.getId());
        QueryWrapper<Nation> eq5 = new QueryWrapper<Nation>().eq("name", employeeVo.getNationId());
        Nation nation = nationMapper.selectOne(eq5);
        employee.setNationId(nation.getId());
        return employee;
    }
}
