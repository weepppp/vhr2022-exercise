package com.qfedu.vhr.system.service.impl;

import com.qfedu.vhr.framework.entity.Hr;
import com.qfedu.vhr.system.entity.Menu;
import com.qfedu.vhr.system.entity.vo.MenuVo;
import com.qfedu.vhr.system.mapper.MenuMapper;
import com.qfedu.vhr.system.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuVo> getAllMenus() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getAllMenusByHrId(hr.getId());
    }
}
