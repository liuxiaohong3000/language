package com.language.word.service.busservice;

import com.alibaba.fastjson.JSON;
import com.language.word.Application;
import com.language.word.common.result.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BusUserServiceTest {

    @Autowired
    private BusUserService busUserService;
    @Test
    public void addUserWord() {
        busUserService.addUserWord(1L,1L,1L);
    }
    @Test
    public void modifyUserWord() {
        busUserService.modifyUserWord(1L);
    }
    @Test
    public void listAllowRecallWord() {
        Results results=busUserService.listAllowRecallWord(1L,1L,1);
        System.out.println(JSON.toJSONString(results));
    }
}
