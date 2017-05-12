package com.language.word.model;
import java.io.Serializable;
import java.util.Date;

public class DUserForgettingCurve extends Base implements Serializable{

	public DUserForgettingCurve() {
		
	}

	/**
	*  ID
	*/
	private Long id;

	/**
	*  名称
	*/
	private String name;

	/**
	*  间隔时间
	*/
	private Long intervalTime;

	/**
	*  类型类型
	*/
	private Integer intervalType;

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
	
	public void setIntervalTime(Long intervalTime){
		this.intervalTime = intervalTime;
	}
	
	public Long getIntervalTime(){
		return intervalTime;
	}
	
	public void setIntervalType(Integer intervalType){
		this.intervalType = intervalType;
	}
	
	public Integer getIntervalType(){
		return intervalType;
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
		return "DUserForgettingCurve{" +
				"id=" + id +
				", name='" + name + '\'' +
				", intervalTime=" + intervalTime +
				", intervalType=" + intervalType +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
