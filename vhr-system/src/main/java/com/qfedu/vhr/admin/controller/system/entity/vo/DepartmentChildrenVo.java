package com.qfedu.vhr.admin.controller.system.entity.vo;

import com.qfedu.vhr.admin.controller.system.entity.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weepppp 2022/7/28 14:33
 **/
public class DepartmentChildrenVo extends Department {

    private List<Department> children = new ArrayList<>();

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
}
