package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    
	private static final long serialVersionUID = -5999681432880620452L;

	private Integer id;

    private String orderNo;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}