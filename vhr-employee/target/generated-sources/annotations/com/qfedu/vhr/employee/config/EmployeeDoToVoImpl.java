package com.qfedu.vhr.employee.config;

import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.employee.entity.vo.EmployeeVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T19:09:41+0800",
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

    @Override
    public Employee employVO2DO(EmployeeVo employeeVo) {
        if ( employeeVo == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeVo.getId() );
        employee.setName( employeeVo.getName() );
        employee.setGender( employeeVo.getGender() );
        employee.setBirthday( employeeVo.getBirthday() );
        employee.setIdCard( employeeVo.getIdCard() );
        employee.setWedlock( employeeVo.getWedlock() );
        employee.setNativePlace( employeeVo.getNativePlace() );
        employee.setEmail( employeeVo.getEmail() );
        employee.setPhone( employeeVo.getPhone() );
        employee.setAddress( employeeVo.getAddress() );
        employee.setEngageForm( employeeVo.getEngageForm() );
        employee.setTiptopDegree( employeeVo.getTiptopDegree() );
        employee.setSpecialty( employeeVo.getSpecialty() );
        employee.setSchool( employeeVo.getSchool() );
        employee.setBeginDate( employeeVo.getBeginDate() );
        employee.setWorkState( employeeVo.getWorkState() );
        employee.setWorkID( employeeVo.getWorkID() );
        employee.setContractTerm( employeeVo.getContractTerm() );
        employee.setConversionTime( employeeVo.getConversionTime() );
        employee.setNotWorkDate( employeeVo.getNotWorkDate() );
        employee.setBeginContract( employeeVo.getBeginContract() );
        employee.setEndContract( employeeVo.getEndContract() );
        employee.setWorkAge( employeeVo.getWorkAge() );

        return employee;
    }
}
