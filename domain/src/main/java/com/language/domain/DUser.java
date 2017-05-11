package com.language.domain;
import java.io.Serializable;
import java.util.Date;

public class DUser implements Serializable{

	public DUser() {
		
	}

	/**
	*  
	*/
	private Long id;

	/**
	*  名称
	*/
	private String name;

	/**
	*  手机号
	*/
	private String mobile;

	/**
	*  备注
	*/
	private String note;

	/**
	*  创建时间
	*/
	private Date createTime;

	/**
	*  更新时间
	*/
	private Date updateTime;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getMobile(){
		return mobile;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public String getNote(){
		return note;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime(){
		return updateTime;
	}

	@Override
	public String toString() {
		return "DUser{" +
				"id=" + id +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
