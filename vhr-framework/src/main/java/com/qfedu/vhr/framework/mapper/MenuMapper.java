package com.qfedu.vhr.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.framework.entity.Menu;
import com.qfedu.vhr.framework.entity.vo.MenuRoleVo;
import com.qfedu.vhr.framework.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVo> getAllMenusByHrId(Integer hrid);

    List<MenuRoleVo> getAllMenuRoles();

}
