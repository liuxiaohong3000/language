package com.language.word.service.dbservice;

import com.github.pagehelper.PageHelper;
import com.language.word.dao.DUserClientMapper;
import com.language.word.model.DUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbUserClientService")
public class DUserClientService {

    @Autowired
    private DUserClientMapper dUserClientDao;

    /**
     * 增加用户对应的客户端ID
     * 
     * @param dUserClient
     * @return Results
     */
    public void add(DUserClient dUserClient) {

		dUserClientDao.save(dUserClient);

    }

    /**
     * 删除用户对应的客户端ID
     * 
     * @param id
     * @return Results
     */
    public void deleteById(Long id) {

		dUserClientDao.deleteById(id);

    }

    /**
     * 修改用户对应的客户端ID
     * 
     * @param dUserClient
     * @return void
     */
    public void modify(DUserClient dUserClient) {

		dUserClientDao.update(dUserClient);

    }

    /**
     * 查询用户对应的客户端ID
     * 
     * @param id
     * @return DUserClient
     */
    public DUserClient findById(Long id) {

		DUserClient dUserClient = dUserClientDao.findById(id);

		return dUserClient;
    }

    /**
     * 按条件分页查询记录
     * 
     * @param searchParams
     *            条件
     * @return List
     */
    public List<DUserClient> listClients(Map<String, Object> searchParams) {

		List<DUserClient> list = dUserClientDao.listUserClient(searchParams);

		return list;
    }

    /**
     * 解除绑定
     * 
     * @param delParams
     * @return
     * @Desc:
     */
    public int deleteByMobileAndClientId(Map<String, Object> delParams) {
		int count = dUserClientDao.deleteByMobileAndClientId(delParams);
		return count;
    }

    public List<DUserClient> searchByPage(Map<String, Object> searchParams, Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		return dUserClientDao.searchByPage(searchParams);
    }

}
