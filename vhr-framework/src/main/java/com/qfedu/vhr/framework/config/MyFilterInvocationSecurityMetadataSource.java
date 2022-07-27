package com.qfedu.vhr.framework.config;

import com.qfedu.vhr.framework.entity.Role;
import com.qfedu.vhr.framework.entity.vo.MenuRoleVo;
import com.qfedu.vhr.framework.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author weepppp 2022/7/26 18:34
 **/
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    IMenuService menuService;

    AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequestUrl();
        List<MenuRoleVo> allMenuRoles = menuService.getAllMenuRoles();
        for (MenuRoleVo allMenuRole : allMenuRoles) {
            if (pathMatcher.match(allMenuRole.getUrl(), url)) {
                Set<Role> roles = allMenuRole.getRoles();
                String[] roleArr = new String[roles.size()];
                int index = 0;
                for (Role role : roles) {
                    roleArr[index++] = role.getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
