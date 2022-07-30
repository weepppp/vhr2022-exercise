package com.qfedu.vhr.employee.config;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-30T10:49:44+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class EmployeeDoToVoImpl implements EmployeeDoToVo {

    @Override
    public EmployeeVo employDO2VO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeVo employeeVo = new EmployeeVo();

        employeeVo.setId( employee.getId() );
        employeeVo.setName( employee.getName() );
        employeeVo.setGender( employee.getGender() );
        employeeVo.setBirthday( employee.getBirthday() );
        employeeVo.setIdCard( employee.getIdCard() );
        employeeVo.setWedlock( employee.getWedlock() );
        employeeVo.setNativePlace( employee.getNativePlace() );
        employeeVo.setEmail( employee.getEmail() );
        employeeVo.setPhone( employee.getPhone() );
        employeeVo.setAddress( employee.getAddress() );
        employeeVo.setEngageForm( employee.getEngageForm() );
        employeeVo.setTiptopDegree( employee.getTiptopDegree() );
        employeeVo.setSpecialty( employee.getSpecialty() );
        employeeVo.setSchool( employee.getSchool() );
        employeeVo.setBeginDate( employee.getBeginDate() );
        employeeVo.setWorkState( employee.getWorkState() );
        employeeVo.setWorkID( employee.getWorkID() );
        employeeVo.setContractTerm( employee.getContractTerm() );
        employeeVo.setConversionTime( employee.getConversionTime() );
        employeeVo.setNotWorkDate( employee.getNotWorkDate() );
        employeeVo.setBeginContract( employee.getBeginContract() );
        employeeVo.setEndContract( employee.getEndContract() );
        employeeVo.setWorkAge( employee.getWorkAge() );

        return employeeVo;
    }
}
