package com.language.word.dao;

import com.language.word.model.DUserForgettingCurve;

import java.util.List;
import java.util.Map;

public interface DUserForgettingCurveMapper {

  	/**
	 * save d_user_forgetting_curve
	 * @param DUserForgettingCurve
	 * @return 
	 */
	 public void save(DUserForgettingCurve dUserForgettingCurve);
	
	/**
	 * update d_user_forgetting_curve
	 * @param DUserForgettingCurve
	 * @return 
	 */
	 public void update(DUserForgettingCurve dUserForgettingCurve);
  	/**
	 * query d_user_forgetting_curve by primary key 
	 * @param Long ID
	 * @return DUserForgettingCurve
	 */
	 public DUserForgettingCurve findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<DUserForgettingCurve> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete d_user_forgetting_curve by primary key 
	 * @param DUserForgettingCurve
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
