package com.language.word.service.dbservice;

import com.language.word.dao.BTypeMapper;
import com.language.word.model.BType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbTypeService")
public class BTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BTypeService.class);
	
	@Autowired
	private BTypeMapper bTypeDao;

	
	/**
	 * 增加类型
	 * @param bType
	 * @return Results
	 */
	public void add(BType bType){
		
		bTypeDao.save(bType);

	}

	
	/**
	 * 删除类型
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		bTypeDao.deleteById(id);

	}

	
	/**
	 * 修改类型
	 * @param bType
	 * @return Results
	 */
	public void modify(BType bType){

		bTypeDao.update(bType);

	}

	
	/**
	 * 查询类型
	 * @param id
	 * @return Results
	 */
	public BType findById(Long id){

		BType bType = bTypeDao.findById(id);

		return bType;
	}

	
	/**
	 * 按条件分页查询记录
	 * @return Results
	 */
	public List<BType> searchByPage() {
		return bTypeDao.searchByPage();
	}

}
