package com.qfedu.vhr.system.entity.vo;

import com.qfedu.vhr.system.entity.Department;

import java.util.List;

/**
 * @author weepppp 2022/7/28 14:33
 **/
public class DepartMentVo extends Department {

    private  List<Department> children;

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
}
