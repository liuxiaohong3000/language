package com.language.word.service.dbservice;

import com.language.word.dao.DMessageMapper;
import com.language.word.model.DMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("dbMessageService")
public class DMessageService {
	
	private static Logger logger = LoggerFactory.getLogger(DMessageService.class);
	
	@Autowired
	private DMessageMapper dMessageDao;

	
	/**
	 * 增加消息
	 * @param dMessage
	 * @return Results
	 */
	public void add(DMessage dMessage){
		
		dMessageDao.save(dMessage);

	}

	
	/**
	 * 删除消息
	 * @param id
	 * @return Results
	 */
	public void deleteById(Long id){

		dMessageDao.deleteById(id);

	}

	
	/**
	 * 修改消息
	 * @param dMessage
	 * @return Results
	 */
	public void modify(DMessage dMessage){

		dMessageDao.update(dMessage);

	}

	
	/**
	 * 查询消息
	 * @param id
	 * @return Results
	 */
	public DMessage findById(Long id){

		DMessage dMessage = dMessageDao.findById(id);

		return dMessage;
	}

	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return Results
	 */
	public List<DMessage> searchByPage(Map<String,Object> searchParams, Integer pageNumber, Integer pageSize) {

		return null;
	}

}
