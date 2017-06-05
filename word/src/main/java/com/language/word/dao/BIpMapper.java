package com.language.word.dao;

import com.language.word.model.BIp;

import java.util.List;
import java.util.Map;

public interface BIpMapper {

    /**
     * save bIp
     * 
     * @param bIp
     * @return
     */
    public void save(BIp bIp);

    /**
     * update b_ip
     * 
     * @param bIp
     * @return
     */
    public void update(BIp bIp);

    /**
     * query b_ip by primary key
     * 
     * @param id
     * @return BIp
     */
    public BIp findById(Long id);

    /**
     * 按条件分页查询记录
     * 
     * @param searchParams
     *            条件
     * @return
     */
    public List<BIp> searchByPage(Map<String, Object> searchParams);

    /**
     * delete b_ip by primary key
     * 
     * @param id
     * @return
     */
    public void deleteById(Long id);


}
