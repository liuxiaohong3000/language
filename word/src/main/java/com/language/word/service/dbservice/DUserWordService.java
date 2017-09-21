package com.language.word.service.dbservice;

import com.github.pagehelper.PageHelper;
import com.language.word.dao.DUserWordMapper;
import com.language.word.model.DUserWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbUserWordService")
public class DUserWordService {
	
	private static Logger logger = LoggerFactory.getLogger(DUserWordService.class);
	
	@Autowired
	private DUserWordMapper dUserWordDao;

	
	/**
	 * 增加用户关键词
	 * @param dUserWord
	 * @return Results
	 */
	public void add(DUserWord dUserWord){
		
		dUserWordDao.save(dUserWord);

	}

	
	/**
	 * 删除用户关键词
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		dUserWordDao.deleteById(id);

	}
	/**
	 * 删除用户关键词
	 */
	public void deleteExpireWord(Long userId){

		dUserWordDao.deleteExpireWord(userId);

	}

	
	/**
	 * 修改用户关键词
	 * @param dUserWord
	 * @return Results
	 */
	public void modify(DUserWord dUserWord){

		dUserWordDao.update(dUserWord);

	}

	
	/**
	 * 查询用户关键词
	 * @param id
	 * @return Results
	 */
	public DUserWord findById(Long id){

		DUserWord dUserWord = dUserWordDao.findById(id);

		return dUserWord;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<DUserWord> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {

		PageHelper.startPage(pageNumber, pageSize);
		return dUserWordDao.searchByPage(searchParams);
	}

	/**
	 * 查询用户关键词
	 * @param searchParams
	 * @return Results
	 */
	public DUserWord findByUserIdAndWordId(Map<String,Object> searchParams){

		DUserWord dUserWord = dUserWordDao.findByUserIdAndWordId(searchParams);

		return dUserWord;
	}
}
