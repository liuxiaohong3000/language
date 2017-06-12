package com.language.word.service.dbservice;

import com.github.pagehelper.PageHelper;
import com.language.word.dao.BForgettingCurveMapper;
import com.language.word.model.BForgettingCurve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dbForgettingCurveService")
public class BForgettingCurveService {
	
	private static Logger logger = LoggerFactory.getLogger(BForgettingCurveService.class);
	
	@Autowired
	private BForgettingCurveMapper bForgettingCurveDao;

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
	 * 查询遗忘曲线
	 * @param id
	 * @return Results
	 */
	public BForgettingCurve findNextById(Long id){
		PageHelper.startPage(1, 1);
		Map<String , Object> params=new HashMap<String, Object>();
		params.put("ltId",id);
		List<BForgettingCurve> curves=bForgettingCurveDao.searchByPage(params);
		if(curves!=null && curves.size()>0){
			return curves.get(0);
		}

		return null;
	}
	
	/**
	 * 按条件分页查询记录
	 * @return Results
	 */
	public List<BForgettingCurve> searchByPage() {

		return bForgettingCurveDao.searchByPage(null);
	}

}
