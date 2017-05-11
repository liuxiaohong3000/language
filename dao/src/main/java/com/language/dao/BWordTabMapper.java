package com.language.dao;
import java.util.List;
import java.util.Map;

import com.language.domain.BWordTab;

public interface BWordTabMapper {

  	/**
	 * save b_word_tab
	 * @param BWordTab
	 * @return 
	 */
	 public void save(BWordTab bWordTab);
	
	/**
	 * update b_word_tab
	 * @param BWordTab
	 * @return 
	 */
	 public void update(BWordTab bWordTab);
  	/**
	 * query b_word_tab by primary key 
	 * @param Long id
	 * @return BWordTab
	 */
	 public BWordTab findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<BWordTab> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete b_word_tab by primary key 
	 * @param BWordTab
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
