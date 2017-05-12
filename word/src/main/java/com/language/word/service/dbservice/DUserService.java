package com.language.word.service.dbservice;

import com.language.word.dao.DUserMapper;
import com.language.word.model.DUser;
import com.language.word.model.DUserWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbUserService")
public class DUserService {
	
	private static Logger logger = LoggerFactory.getLogger(DUserService.class);
	
	@Autowired
	private DUserMapper dUserDao;

	
	/**
	 * 增加用户
	 * @param dUser
	 * @return Results
	 */
	public void add(DUser dUser){
		
		dUserDao.save(dUser);

	}

	
	/**
	 * 删除用户
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		dUserDao.deleteById(id);

	}

	
	/**
	 * 修改用户
	 * @param dUser
	 * @return Results
	 */
	public void modify(DUser dUser){

		dUserDao.update(dUser);

	}

	
	/**
	 * 查询用户
	 * @param id
	 * @return Results
	 */
	public DUser findById(Long id){

		DUser dUser = dUserDao.findById(id);

		return dUser;
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
