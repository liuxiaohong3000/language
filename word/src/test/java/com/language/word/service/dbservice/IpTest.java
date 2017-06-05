package com.language.word.service.dbservice;

import com.gexin.fastjson.JSON;
import com.language.word.Application;
import com.language.word.model.BIp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class IpTest {

    @Autowired
    private BIpService dbIpService;

    @Test
    public void add() {
        BIp ip = new BIp();
        ip.setIp("1111");
        ip.setStatus(1);
        ip.setCreateTime(new Date());
        dbIpService.add(ip);
    }

    @Test
    public void deleteById() {
        dbIpService.deleteById(2L);
    }

    @Test
    public void modify() {
        BIp ip = new BIp();
        ip.setId(1L);
        ip.setIp("1111");
        ip.setStatus(1);
        ip.setCreateTime(new Date());
        dbIpService.modify(ip);
    }

    @Test
    public void findById() {
        BIp ip = dbIpService.findById(1L);
        System.out.println(JSON.toJSONString(ip));
    }

    @Test
    public void searchByPage() {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        List<BIp>  ips= dbIpService.searchByPage(searchParams, 1, 10);
        System.out.println(JSON.toJSONString(ips));
    }
}
