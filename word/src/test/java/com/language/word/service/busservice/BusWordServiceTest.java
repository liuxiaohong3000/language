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
public class BusWordServiceTest {

    @Autowired
    private BusWordService busWordService;
    @Test
    public void listWord() {
        Results results=busWordService.listWord(9L,2);
        System.out.println(JSON.toJSONString(results));
    }
    @Test
    public void addWord() {
        Results results=busWordService.addWord("1","1",1,"1","1","1","1","1");
        System.out.println(JSON.toJSONString(results));
    }

    @Test
    public void listTypes() {
        Results results=busWordService.listTypes();
        System.out.println(JSON.toJSONString(results));
    }

}
