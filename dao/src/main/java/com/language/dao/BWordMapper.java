package com.language.dao;
import java.util.List;
import java.util.Map;
import com.language.domain.BWord;

public interface BWordMapper {

  	/**
	 * save b_word
	 * @param BWord
	 * @return 
	 */
	 public void save(BWord bWord);
	
	/**
	 * update b_word
	 * @param BWord
	 * @return 
	 */
	 public void update(BWord bWord);
  	/**
	 * query b_word by primary key 
	 * @param Long id
	 * @return BWord
	 */
	 public BWord findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<BWord> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete b_word by primary key 
	 * @param BWord
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
