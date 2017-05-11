package com.language.dao;
import com.language.domain.BForgettingCurve;

import java.util.List;
import java.util.Map;

public interface BForgettingCurveMapper {

  	/**
	 * save b_forgetting_curve
	 * @param BForgettingCurve
	 * @return 
	 */
	 public void save(BForgettingCurve bForgettingCurve);
	
	/**
	 * update b_forgetting_curve
	 * @param BForgettingCurve
	 * @return 
	 */
	 public void update(BForgettingCurve bForgettingCurve);
  	/**
	 * query b_forgetting_curve by primary key 
	 * @param Long ID
	 * @return BForgettingCurve
	 */
	 public BForgettingCurve findById(Long id);
	 
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	 List<BForgettingCurve> searchByPage(Map<String, Object> searchParams);
	 
	 /**
	 * delete b_forgetting_curve by primary key 
	 * @param Long id
	 * @return 
	 */
	 public void deleteById(Long id);
	 
}
