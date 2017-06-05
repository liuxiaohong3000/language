package com.language.word.model;
import java.io.Serializable;
import java.util.Date;

public class BIp implements Serializable{

	public BIp() {
		
	}

	/**
	*  
	*/
	private Long id;

	/**
	*  ip
	*/
	private String ip;

	/**
	*  状态
	*/
	private Integer status;

	/**
	*  创建时间
	*/
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
