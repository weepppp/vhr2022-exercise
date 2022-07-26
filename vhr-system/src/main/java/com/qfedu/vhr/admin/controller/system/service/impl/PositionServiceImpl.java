package com.qfedu.vhr.admin.controller.system.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import com.qfedu.vhr.admin.controller.system.entity.Position;
import com.qfedu.vhr.admin.controller.system.excel.PositionListener;
import com.qfedu.vhr.admin.controller.system.mapper.PositionMapper;
import com.qfedu.vhr.admin.controller.system.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Override
    public int savePosition(Position position) {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Position::getName, position.getName());
        Position one = getOne(wrapper);
        if (one != null) {
            return -1;
        }
        position.setCreateDate(LocalDateTime.now());
        position.setEnabled(true);
        return save(position) ? 1 : -2;
    }

    @Override
    public int deletePositionById(Integer id) {
        Position p = getById(id);
        if (p == null) {
            return -1;
        }
        return removeById(id) ? 1 : -2;
    }

    @Override
    public RespBean importPositionData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Position.class,new PositionListener(this)).sheet().doRead();
            return RespBean.ok("导入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("导入失败");
    }

    @Override
    public RespPageBean getPositionByPage(Integer page, Integer size) {
        Page<Position> p = page(Page.of(page, size));
        return new RespPageBean(p.getTotal(),p.getRecords());
    }
}
