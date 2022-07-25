package com.qfedu.vhr.system.service;

import com.qfedu.vhr.system.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.vhr.system.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
public interface IMenuService extends IService<Menu> {

    List<MenuVo> getAllMenus();

}
