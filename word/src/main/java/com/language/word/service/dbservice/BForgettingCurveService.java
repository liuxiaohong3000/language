package com.language.word.service.dbservice;

import com.language.word.dao.BForgettingCurveMapper;
import com.language.word.model.BForgettingCurve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbForgettingCurveService")
public class BForgettingCurveService {
	
	private static Logger logger = LoggerFactory.getLogger(BForgettingCurveService.class);
	
	@Autowired
	private BForgettingCurveMapper bForgettingCurveDao;

	
	/**
	 * 增加遗忘曲线
	 * @param bForgettingCurve
	 * @return Results
	 */
	public void add(BForgettingCurve bForgettingCurve){
		
		bForgettingCurveDao.save(bForgettingCurve);

	}

	
	/**
	 * 删除遗忘曲线
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		bForgettingCurveDao.deleteById(id);

	}

	
	/**
	 * 修改遗忘曲线
	 * @param bForgettingCurve
	 * @return Results
	 */
	public void modify(BForgettingCurve bForgettingCurve){

		bForgettingCurveDao.update(bForgettingCurve);

	}

	
	/**
	 * 查询遗忘曲线
	 * @param id
	 * @return Results
	 */
	public BForgettingCurve findById(Long id){

		BForgettingCurve bForgettingCurve = bForgettingCurveDao.findById(id);

		return bForgettingCurve;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<BForgettingCurve> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {

		return null;
	}

}
