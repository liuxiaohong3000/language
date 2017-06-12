package com.language.word.service.busservice;

import com.language.word.common.constant.ReturnStatusConstant;
import com.language.word.common.result.Results;
import com.language.word.model.BForgettingCurve;
import com.language.word.service.dbservice.BForgettingCurveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("busForgetService")
public class BusForgetService {
	
	private static Logger logger = LoggerFactory.getLogger(BusForgetService.class);

	@Autowired
	private BForgettingCurveService dbForgettingCurveService;


	/**
	 * 遗忘列表
	 * @return
	 */
	public Results listForgets(){

		List<BForgettingCurve> forgets=dbForgettingCurveService.searchByPage();
		
		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),forgets);
		
		return results; 
	}

}
