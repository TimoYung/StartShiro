package com.github.zhangkaitao.shiro.chapter16.entity;

import java.io.Serializable;

public class Organization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -725041687418492119L;
	private Integer id;
	private String name;
	private Integer prioty; //显示顺序
	private Integer parent_id;
	private String parent_ids;
	private Boolean available;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrioty() {
		return prioty;
	}
	public void setPrioty(Integer prioty) {
		this.prioty = prioty;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_ids() {
		return parent_ids;
	}
	public void setParent_ids(String parent_ids) {
		this.parent_ids = parent_ids;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
}
