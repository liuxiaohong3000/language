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
public class BusForgetServiceTest {

    @Autowired
    private BusForgetService busForgetService;

    @Test
    public void listForgets() {
        Results results=busForgetService.listForgets();
        System.out.println(JSON.toJSONString(results));
    }
}
