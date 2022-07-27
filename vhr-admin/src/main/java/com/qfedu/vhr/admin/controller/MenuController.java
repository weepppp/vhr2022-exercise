package com.qfedu.vhr.admin.controller;

import com.qfedu.vhr.framework.entity.vo.MenuVo;
import com.qfedu.vhr.framework.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weepppp 2022/7/25 16:53
 **/
@RestController
public class MenuController {

    @Autowired
    IMenuService menuService;

    @GetMapping("/menus")
    public List<MenuVo> getAllMenus() {
        return menuService.getAllMenus();
    }
}
