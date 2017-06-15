package com.language.word.service.dbservice;

import com.language.word.dao.BWordTabMapper;
import com.language.word.model.BWordTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbWordTabService")
public class BWordTabService {
	
	private static Logger logger = LoggerFactory.getLogger(BWordTabService.class);
	
	@Autowired
	private BWordTabMapper bWordTabDao;

	
	/**
	 * 增加关键词标签
	 * @param bWordTab
	 * @return Results
	 */
	public void add(BWordTab bWordTab){
		
		bWordTabDao.save(bWordTab);

	}

	
	/**
	 * 删除关键词标签
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		bWordTabDao.deleteById(id);
	}

	
	/**
	 * 修改关键词标签
	 * @param bWordTab
	 * @return Results
	 */
	public void modify(BWordTab bWordTab){

		bWordTabDao.update(bWordTab);

	}

	
	/**
	 * 查询关键词标签
	 * @param id
	 * @return Results
	 */
	public BWordTab findById(Long id){

		BWordTab bWordTab = bWordTabDao.findById(id);

		return bWordTab;
	}

	/**
	 * 查询关键词标签
	 * @param id
	 * @return Results
	 */
	public BWordTab findByWordId(Long id){

		BWordTab bWordTab = bWordTabDao.findByWordId(id);

		return bWordTab;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<BWordTab> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {
		

		return null;
	}

}
