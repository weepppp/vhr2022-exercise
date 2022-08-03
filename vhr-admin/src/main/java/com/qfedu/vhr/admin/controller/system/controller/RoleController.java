package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.Role;
import com.qfedu.vhr.framework.entity.vo.MenuVo;
import com.qfedu.vhr.framework.service.IMenuService;
import com.qfedu.vhr.admin.controller.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weepppp 2022/7/29 14:32
 **/
@RestController
@RequestMapping("/system/basic/role")
public class RoleController {
    @Autowired
    IRoleService roleService;
    @Autowired
    IMenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
            return roleService.list();
    }

    @GetMapping("/menus")
    public List<MenuVo> getAllMenus(){
        return menuService.getAllMenusWithChildren();
    }

    @GetMapping("/selectedMenus")
    public List<Integer> getSelectedMenus(String name){
        return menuService.getSelectedMenus(name);
    }

    @PutMapping("/")
    public RespBean updateRoleMenus(Integer rid,Integer[] mid){
        return menuService.updateRoleMenus(rid,mid);
    }
}
