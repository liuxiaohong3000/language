package com.language.word.service.dbservice;

import com.gexin.fastjson.JSON;
import com.language.word.Application;
import com.language.word.model.DUserClient;
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
public class UserClientTest {

    @Autowired
    private DUserClientService dbUserClientService;

    @Test
    public void add() {
        DUserClient userClient = new DUserClient();
        userClient.setMobile("1111");
        userClient.setClientId("111111111111111");
        userClient.setStatus(1);
        userClient.setCreateTime(new Date());
        dbUserClientService.add(userClient);
    }

    @Test
    public void deleteById() {
        dbUserClientService.deleteById(2L);
    }

    @Test
    public void modify() {
        DUserClient userClient = new DUserClient();
        userClient.setId(1L);
        userClient.setMobile("222");
        userClient.setClientId("1111122221111111111");
        userClient.setStatus(1);
        userClient.setCreateTime(new Date());
        dbUserClientService.modify(userClient);
    }

    @Test
    public void findById() {
        DUserClient userClient = dbUserClientService.findById(1L);
        System.out.println(JSON.toJSONString(userClient));
    }

    @Test
    public void searchByPage() {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        List<DUserClient>  userClientS= dbUserClientService.searchByPage(searchParams, 1, 10);
        System.out.println(JSON.toJSONString(userClientS));
    }
    @Test
    public void deleteByMobileAndClientId() {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("mobile","222");
        searchParams.put("clientId","1111122221111111111");
        dbUserClientService.deleteByMobileAndClientId(searchParams);
    }
}
