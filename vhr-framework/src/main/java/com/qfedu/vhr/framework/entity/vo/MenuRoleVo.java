package com.qfedu.vhr.framework.entity.vo;


import com.qfedu.vhr.framework.entity.Menu;
import com.qfedu.vhr.framework.entity.Role;

import java.util.Set;

/**
 * @author weepppp 2022/7/26 18:39
 **/
public class MenuRoleVo extends Menu {
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
