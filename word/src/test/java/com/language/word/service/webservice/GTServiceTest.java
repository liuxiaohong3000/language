package com.language.word.service.webservice;

import com.alibaba.fastjson.JSON;
import com.language.word.Application;
import com.language.word.common.constant.MessageTypeEnum;
import com.language.word.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class GTServiceTest {
    @Autowired
    private GTService gtService;
    @Test
    public void testToClent() {
        try{
            Message message=new Message();
            message.setType(MessageTypeEnum.IP.value());
            message.setMessage(InetAddress.getLocalHost().getHostAddress());
            gtService.pushMessageToClient("2276803076900d28c30d3b6fcff5125f", JSON.toJSONString(message) );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testToApp() {
        try{
            Message message=new Message();
            message.setType(MessageTypeEnum.IP.value());
            message.setMessage(InetAddress.getLocalHost().getHostAddress());
            gtService.pushMessageToApp(JSON.toJSONString(message) );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
