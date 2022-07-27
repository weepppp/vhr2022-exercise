package com.qfedu.vhr.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.vhr.framework.entity.Menu;
import com.qfedu.vhr.framework.entity.vo.MenuRoleVo;
import com.qfedu.vhr.framework.entity.vo.MenuVo;

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

    List<MenuRoleVo> getAllMenuRoles();

}
