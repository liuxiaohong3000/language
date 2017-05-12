package com.language.word.service.dbservice;

import com.language.word.dao.DUserForgettingCurveMapper;
import com.language.word.model.DUserForgettingCurve;
import com.language.word.model.DUserWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbUserForgettingCurveService")
public class DUserForgettingCurveService {
	
	private static Logger logger = LoggerFactory.getLogger(DUserForgettingCurveService.class);
	
	@Autowired
	private DUserForgettingCurveMapper dUserForgettingCurveDao;

	
	/**
	 * 增加用户遗忘曲线
	 * @param dUserForgettingCurve
	 * @return Results
	 */
	public void add(DUserForgettingCurve dUserForgettingCurve){
		
		dUserForgettingCurveDao.save(dUserForgettingCurve);

	}

	
	/**
	 * 删除用户遗忘曲线
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		dUserForgettingCurveDao.deleteById(id);

	}

	
	/**
	 * 修改用户遗忘曲线
	 * @param dUserForgettingCurve
	 * @return Results
	 */
	public void modify(DUserForgettingCurve dUserForgettingCurve){

		dUserForgettingCurveDao.update(dUserForgettingCurve);

	}

	
	/**
	 * 查询用户遗忘曲线
	 * @param id
	 * @return Results
	 */
	public DUserForgettingCurve findById(Long id){

		DUserForgettingCurve dUserForgettingCurve = dUserForgettingCurveDao.findById(id);

		return dUserForgettingCurve;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<DUserWord> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {

		return null;
	}

}
