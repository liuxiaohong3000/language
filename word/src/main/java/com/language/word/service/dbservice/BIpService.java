package com.language.word.service.dbservice;

import com.github.pagehelper.PageHelper;
import com.language.word.dao.BIpMapper;
import com.language.word.model.BIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dbIpService")
public class BIpService {

    @Autowired
    private BIpMapper bIpMapper;

    /**
     * 增加用户对应的客户端ID
     * 
     * @param bip
     * @return Results
     */
    public void add(BIp bip) {

        bIpMapper.save(bip);

    }

    /**
     * 删除用户对应的客户端ID
     * 
     * @param id
     * @return Results
     */
    public void deleteById(Long id) {

        bIpMapper.deleteById(id);

    }

    /**
     *
     * @param bip
     * @return void
     */
    public void modify(BIp bip) {

        bIpMapper.update(bip);

    }

    /**
     *
     * @param id
     * @return BIp
     */
    public BIp findById(Long id) {

        BIp bip = bIpMapper.findById(id);

		return bip;
    }

    public List<BIp> searchByPage(Map<String, Object> searchParams, Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		return bIpMapper.searchByPage(searchParams);
    }

}
