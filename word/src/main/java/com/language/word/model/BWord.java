package com.language.word.model;
import java.io.Serializable;
import java.util.Date;

public class BWord extends Base implements Serializable{

	public BWord() {

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
	*  翻译
	*/
	private String translate;

	/**
	*  类型ID
	*/
	private Integer typeId;

	/**
	*  备注
	*/
	private String note;

	/**
	*  创建时间
	*/
	private Date createTime;
	
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
	
	public void setTranslate(String translate){
		this.translate = translate;
	}
	
	public String getTranslate(){
		return translate;
	}
	
	public void setTypeId(Integer typeId){
		this.typeId = typeId;
	}
	
	public Integer getTypeId(){
		return typeId;
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

	@Override
	public String toString() {
		return "BWord{" +
				"id=" + id +
				", name='" + name + '\'' +
				", translate='" + translate + '\'' +
				", typeId=" + typeId +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
