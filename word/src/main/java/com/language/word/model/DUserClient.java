package com.language.word.model;
import java.io.Serializable;
import java.util.Date;

public class DUserClient implements Serializable{

	public DUserClient() {
		
	}

	/**
	*  
	*/
	private Long id;

	/**
	*  手机号
	*/
	private String mobile;

	/**
	*  客户端ID
	*/
	private String clientId;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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
