package com.qfedu.vhr.framework.entity.vo;


import com.qfedu.vhr.framework.entity.Menu;

import java.util.List;

/**
 * @author weepppp 2022/7/25 16:57
 **/
public class MenuVo extends Menu {

    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
