package com.language.word.dao;

import com.language.word.model.DUserWord;

import java.util.List;
import java.util.Map;

public interface DUserWordMapper {

  	/**
	 * save d_user_word
	 * @param DUserWord
	 * @return 
	 */
	 public void save(DUserWord dUserWord);
	
	/**
	 * update d_user_word
	 * @param DUserWord
	 * @return 
	 */
	 public void update(DUserWord dUserWord);
  	/**
	 * query d_user_word by primary key 
	 * @param Long ID
	 * @return DUserWord
	 */
	 public DUserWord findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<DUserWord> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete d_user_word by primary key 
	 * @param DUserWord
	 * @return 
	 */
	 public void deleteById(Long id);
	/**
	 * query d_user_word by primary key
	 * @param Long ID
	 * @return DUserWord
	 */
	public DUserWord findByUserIdAndWordId(Map<String, Object> searchParams);
}
