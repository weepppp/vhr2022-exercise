package com.qfedu.vhr.system.service.impl;

import com.qfedu.vhr.system.entity.Department;
import com.qfedu.vhr.system.entity.vo.DepartMentVo;
import com.qfedu.vhr.system.mapper.DepartmentMapper;
import com.qfedu.vhr.system.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<DepartMentVo> getAllDepts() {
        return departmentMapper.getAllDepts(-1);
    }
}
