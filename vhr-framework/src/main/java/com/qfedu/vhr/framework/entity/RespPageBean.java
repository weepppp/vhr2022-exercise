package com.qfedu.vhr.framework.entity;

import java.util.List;

/**
 * @author weepppp 2022/7/28 13:41
 **/
public class RespPageBean {

    private Long total;
    private List<?> data;

    public RespPageBean() {
    }

    public RespPageBean(Long total, List<?> data) {
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
