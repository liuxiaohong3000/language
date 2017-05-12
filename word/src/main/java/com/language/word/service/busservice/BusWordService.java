package com.language.word.service.busservice;

import com.language.word.common.constant.ReturnStatusConstant;
import com.language.word.common.result.Results;
import com.language.word.model.BType;
import com.language.word.service.dbservice.BTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("busWordService")
public class BusWordService {
	
	private static Logger logger = LoggerFactory.getLogger(BusWordService.class);
	
	@Autowired
	private BTypeService dbTypeService;


	/**
	 * 类型列表
	 * @return
	 */
	public Results listType(){

		List<BType> types= dbTypeService.searchByPage(null,1,10);
		
		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),types);
		
		return results; 
	}

}
