package com.language.dao;
import com.language.domain.BType;

import java.util.List;
import java.util.Map;

public interface BTypeMapper {

  	/**
	 * save b_type
	 * @param BType
	 * @return 
	 */
	 public void save(BType bType);
	
	/**
	 * update b_type
	 * @param BType
	 * @return 
	 */
	 public void update(BType bType);
  	/**
	 * query b_type by primary key 
	 * @param Long id
	 * @return BType
	 */
	 public BType findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<BType> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete b_type by primary key 
	 * @param Long id
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
