package com.language.domain;
import java.io.Serializable;
import java.util.Date;

public class DMessage implements Serializable{

	public DMessage() {
		
	}

	/**
	*  
	*/
	private Long id;

	/**
	*  消息名称
	*/
	private String name;

	/**
	*  消息类型
	*/
	private Integer type;

	/**
	*  消息状态
	*/
	private Integer status;

	/**
	*  消息描述
	*/
	private String summary;

	/**
	*  消息内容
	*/
	private String content;

	/**
	*  发送人
	*/
	private Long sendUser;

	/**
	*  接收人
	*/
	private Long receiveUser;

	/**
	*  发送时间
	*/
	private Date sendTime;

	/**
	*  接收时间
	*/
	private Date receiveTime;

	/**
	*  备注
	*/
	private String note;

	/**
	*  创建时间
	*/
	private Date createTime;

	/**
	*  时间截
	*/
	private Date timestamp;
	
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
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setSummary(String summary){
		this.summary = summary;
	}
	
	public String getSummary(){
		return summary;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setSendUser(Long sendUser){
		this.sendUser = sendUser;
	}
	
	public Long getSendUser(){
		return sendUser;
	}
	
	public void setReceiveUser(Long receiveUser){
		this.receiveUser = receiveUser;
	}
	
	public Long getReceiveUser(){
		return receiveUser;
	}

	public void setSendTime(Date sendTime){
		this.sendTime = sendTime;
	}
	
	public Date getSendTime(){
		return sendTime;
	}

	public void setReceiveTime(Date receiveTime){
		this.receiveTime = receiveTime;
	}
	
	public Date getReceiveTime(){
		return receiveTime;
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

	public void setTimestamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}

	@Override
	public String toString() {
		return "DMessage{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type=" + type +
				", status=" + status +
				", summary='" + summary + '\'' +
				", content='" + content + '\'' +
				", sendUser=" + sendUser +
				", receiveUser=" + receiveUser +
				", sendTime=" + sendTime +
				", receiveTime=" + receiveTime +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				", timestamp=" + timestamp +
				'}';
	}
}
