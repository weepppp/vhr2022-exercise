package com.qfedu.vhr.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.vhr.employee.entity.Employee;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qf
 * @since 2022-07-29
 */
public interface IEmployeeService extends IService<Employee> {

    RespPageBean getAllEmployees(Integer page, Integer size);

    RespBean addEmployees(Employee employee);

    RespBean importPositionData(MultipartFile file);

    void addMailEmployees(Employee employee);

}
