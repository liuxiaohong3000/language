package com.language.dao;
import java.util.List;
import java.util.Map;

import com.language.domain.DUser;

public interface DUserMapper {

  	/**
	 * save d_user
	 * @param DUser
	 * @return 
	 */
	 public void save(DUser dUser);
	
	/**
	 * update d_user
	 * @param DUser
	 * @return 
	 */
	 public void update(DUser dUser);
  	/**
	 * query d_user by primary key 
	 * @param Long id
	 * @return DUser
	 */
	 public DUser findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<DUser> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete d_user by primary key 
	 * @param DUser
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
