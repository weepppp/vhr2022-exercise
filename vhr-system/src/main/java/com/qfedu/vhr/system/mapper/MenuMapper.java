package com.qfedu.vhr.system.mapper;

import com.qfedu.vhr.system.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.vhr.system.entity.vo.MenuVo;

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

}
