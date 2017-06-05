package com.language.word.dao;

import com.language.word.model.DUserClient;

import java.util.List;
import java.util.Map;

public interface DUserClientMapper {

    /**
     * save d_user_client
     * 
     * @param dUserClient
     * @return
     */
    public void save(DUserClient dUserClient);

    /**
     * update message_user_client
     * 
     * @param dUserClient
     * @return
     */
    public void update(DUserClient dUserClient);

    /**
     * query message_user_client by primary key
     * 
     * @param id
     * @return DUserClient
     */
    public DUserClient findById(Long id);

    /**
     * 按条件分页查询记录
     * 
     * @param searchParams
     *            条件
     * @return
     */
    public List<DUserClient> searchByPage(Map<String, Object> searchParams);

    /**
     * delete message_user_client by primary key
     * 
     * @param id
     * @return
     */
    public void deleteById(Long id);
    /**
     * @param delParams
     * @return
     */
    public int deleteByMobileAndClientId(Map<String, Object> delParams);
    /**
     * 按条件分页查询记录
     * 
     * @param searchParams
     *            条件
     * @return
     */
    public List<DUserClient> listUserClient(Map<String, Object> searchParams);

}
