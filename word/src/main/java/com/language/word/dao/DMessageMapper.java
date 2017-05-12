package com.language.word.dao;

import com.language.word.model.DMessage;

import java.util.List;
import java.util.Map;

public interface DMessageMapper {

  	/**
	 * save d_message
	 * @param DMessage
	 * @return 
	 */
	 public void save(DMessage dMessage);
	
	/**
	 * update d_message
	 * @param DMessage
	 * @return 
	 */
	 public void update(DMessage dMessage);
  	/**
	 * query d_message by primary key 
	 * @param Long id
	 * @return DMessage
	 */
	 public DMessage findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<DMessage> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete d_message by primary key 
	 * @param DMessage
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
