package com.language.word.service.busservice;

import com.language.word.common.constant.GlobalConstant;
import com.language.word.common.constant.ReturnStatusConstant;
import com.language.word.common.result.Results;
import com.language.word.model.BType;
import com.language.word.model.BWord;
import com.language.word.model.BWordTab;
import com.language.word.model.vo.WordVO;
import com.language.word.service.dbservice.BTypeService;
import com.language.word.service.dbservice.BWordService;
import com.language.word.service.dbservice.BWordTabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("busWordService")
public class BusWordService {
	
	private static Logger logger = LoggerFactory.getLogger(BusWordService.class);
	
	@Autowired
	private BTypeService dbTypeService;

	@Autowired
	private BWordService dbWordService;

	@Autowired
	private BWordTabService dbWordTabService;

	/**
	 * 关键字类型列表
	 * @return
	 */
	public Results listTypes(){
		List<BType> returnTypes=new ArrayList<BType>();
		Map<Long,BType> typeMap=new HashMap<Long,BType>();
		List<BType> dbTypes= dbTypeService.searchByPage();
		for(BType type : dbTypes){
			typeMap.put(type.getId(),type);
			if(type.getParentId() == 0L){
				returnTypes.add(type);
			}
		}

		for(BType type : dbTypes){
			if(type.getParentId() != 0L){//获取上一级
				if(typeMap.containsKey(type.getParentId())){
					BType parentType=typeMap.get(type.getParentId());
					parentType.addSubTypeToList(type);
				}
			}
		}
		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),returnTypes);

		return results;
	}

	/**
	 * 新增关键词
	 * @return
	 */
	public Results addWord(String name, String translate, Integer typeId, String synonym, String wordClasses, String shorthand, String phrases, String otherInfo){

		BWord word=new BWord();
		word.setName(name);
		word.setTranslate(translate);
		word.setTypeId(typeId);
		dbWordService.add(word);

		BWordTab wtab=new BWordTab();
		wtab.setSynonym(synonym);
		wtab.setWordClasses(wordClasses);
		wtab.setShorthand(shorthand);
		wtab.setPhrases(phrases);
		wtab.setOtherInfo(otherInfo);
		wtab.setWordId(word.getId());
		dbWordTabService.add(wtab);

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc());

		return results;
	}
	/**
	 * 关键字列表
	 * @return
	 */
	public Results listWord(Long typeId,int pageNum){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("typeId",typeId);
		List<BWord> types= dbWordService.searchByPage(params,pageNum, GlobalConstant.PAGESIZE);

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),types);

		return results;
	}

	/**
	 * 关键字
	 * @return
	 */
	public Results getWord(long id){

		WordVO vo =new WordVO();
		BWord word = dbWordService.findById(id);
		BWordTab tab = dbWordTabService.findByWordId(word.getId());
		vo.setWord(word);
		vo.setTab(tab);

		Results results = new Results(
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.value(),
				ReturnStatusConstant.API_RETURN_STATUS.NORMAL.desc(),vo);

		return results;
	}

}
