package com.example.demo.bean;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 * 
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 8306589021567885137L;

	private int id;
	
	@ApiModelProperty("名字")
	private String name;
	
	@ApiModelProperty("创建时间")
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}