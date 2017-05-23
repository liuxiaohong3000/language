package com.language.word.service.dbservice;

import com.github.pagehelper.PageHelper;
import com.language.word.dao.BWordMapper;
import com.language.word.model.BWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbWordService")
public class BWordService {
	
	private static Logger logger = LoggerFactory.getLogger(BWordService.class);
	
	@Autowired
	private BWordMapper bWordDao;

	
	/**
	 * 增加关键词
	 * @param bWord
	 * @return Results
	 */
	public void add(BWord bWord){
		
		bWordDao.save(bWord);

	}

	
	/**
	 * 删除关键词
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		bWordDao.deleteById(id);

	}

	
	/**
	 * 修改关键词
	 * @param bWord
	 * @return Results
	 */
	public void modify(BWord bWord){

		bWordDao.update(bWord);

	}

	
	/**
	 * 查询关键词
	 * @param id
	 * @return Results
	 */
	public BWord findById(Long id){

		BWord bWord = bWordDao.findById(id);

		return bWord;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<BWord> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		return bWordDao.searchByPage(searchParams);
	}

}
