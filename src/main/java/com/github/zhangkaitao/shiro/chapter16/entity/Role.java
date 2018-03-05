package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7952769059636365480L;

	private Integer id;
	private String role;
	private String description;
	private String resouce_ids;
	private Boolean available;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResouce_ids() {
		return resouce_ids;
	}
	public void setResouce_ids(String resouce_ids) {
		this.resouce_ids = resouce_ids;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
}
