package com.qfedu.vhr.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.vhr.system.entity.Joblevel;
import com.qfedu.vhr.system.mapper.JoblevelMapper;
import com.qfedu.vhr.system.service.IJoblevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
@Service
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper, Joblevel> implements IJoblevelService {

    @Override
    public int addJobLevel(Joblevel joblevel) {
        QueryWrapper<Joblevel> qw = new QueryWrapper<>();
        qw.lambda().eq(Joblevel::getName, joblevel.getName());
        Joblevel joblevel1 = getOne(qw);
        if (joblevel1 != null) {
            return -1;
        }
        joblevel.setCreateDate(LocalDateTime.now());
        joblevel.setEnabled(true);
        return save(joblevel) ? 1 : -2;
    }

    @Override
    public int deleteJobLevel(Integer id) {
        Joblevel joblevel = getById(id);
        if (joblevel == null) {
            return -1;
        }
        return removeById(id) ? 1 : -2;
    }
}
