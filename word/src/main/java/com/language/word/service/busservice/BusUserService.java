package com.language.word.service.busservice;

import com.language.word.common.constant.GlobalConstant;
import com.language.word.common.constant.ReturnStatusConstant;
import com.language.word.common.result.Results;
import com.language.word.model.BForgettingCurve;
import com.language.word.model.DUserWord;
import com.language.word.model.vo.WordVO;
import com.language.word.service.dbservice.BForgettingCurveService;
import com.language.word.service.dbservice.DUserWordService;
import com.language.word.util.IntervalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("busUserService")
public class BusUserService {
	
	private static Logger logger = LoggerFactory.getLogger(BusUserService.class);

	@Autowired
	private BForgettingCurveService dbForgettingCurveService;

	@Autowired
	private DUserWordService dbUserWordService;

	@Autowired
	private BusWordService busWordService;

	/**
	 * 新增用户记忆关键词
	 * @return
	 */
	public Results addUserWord(Long userId,Long forgetId,Long wordId){

		//获取关键词
		Results wordResults=busWordService.getWord(wordId);
		WordVO vo=(WordVO)wordResults.getData();

		//获取遗忘曲线
		BForgettingCurve forgetCurve=dbForgettingCurveService.findById(forgetId);

		DUserWord duw=new DUserWord();
		duw.setUserId(userId);
		duw.setWordId(vo.getWord().getId());
		duw.setWordName(vo.getWord().getName());
		duw.setWordType(vo.getWord().getTypeId());
		duw.setMemoryTime(new Date());
		duw.setCreateTime(new Date());
		duw.setUserForgettingCurveId(forgetCurve.getId());
		duw.setRecallTime(IntervalUtil.getIntervalTime(forgetCurve.getIntervalType(),forgetCurve.getIntervalTime()));
		dbUserWordService.add(duw);

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc());

		return results;
	}

	/**
	 * 修改用户关键词复习时间
	 * @return
	 */
	public Results modifyUserWord(Long userWordId){

		//查询用户关键词
		DUserWord duw=dbUserWordService.findById(userWordId);

		//获取下一个遗忘曲线
		BForgettingCurve forgetCurve=dbForgettingCurveService.findNextById(duw.getUserForgettingCurveId());
		if(forgetCurve!=null){
			duw.setUserForgettingCurveId(forgetCurve.getId());
			duw.setRecallTime(IntervalUtil.getIntervalTime(forgetCurve.getIntervalType(),forgetCurve.getIntervalTime()));
			dbUserWordService.modify(duw);
		}

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc());

		return results;
	}

	/**
	 * 获取允许回忆的列表
	 * @return
	 */
	public Results listAllowRecallWord(Long userId, Long wordType, int pageNum){
		Map<String , Object> params=new HashMap<String, Object>();
		params.put("userId",userId);
		params.put("wordType",wordType);
		params.put("allowRecallTime",new Date());
		List<DUserWord> types= dbUserWordService.searchByPage(params,pageNum, GlobalConstant.PAGESIZE);

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),types);
		
		return results; 
	}

}
