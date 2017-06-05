package com.language.word.service.busservice;

import com.alibaba.fastjson.JSON;
import com.language.word.common.constant.MessageTypeEnum;
import com.language.word.common.constant.StatusEnum;
import com.language.word.model.BIp;
import com.language.word.model.Message;
import com.language.word.service.dbservice.BIpService;
import com.language.word.service.webservice.GTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 */
@Service("busClientService")
public class BusClientService {
    @Autowired
    private BIpService dbIpService;

    @Autowired
    private GTService gtService;

    public BIp queryValidIp(){
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("status", StatusEnum.valid.value());
        List<BIp> ips= dbIpService.searchByPage(searchParams, 1, 1);
        if(ips!=null && ips.size()>0){
            return ips.get(0);
        }
        return null;
    }

    public void saveValidIp(String cirip){
        BIp ip = new BIp();
        ip.setIp(cirip);
        ip.setStatus(StatusEnum.valid.value());
        ip.setCreateTime(new Date());
        dbIpService.add(ip);
    }

    public void modifyIp(BIp ip){
        dbIpService.modify(ip);

    }

    public void pushMessage(String curip) throws Exception{
        //广播消息，通知IP
        Message message=new Message();
        message.setType(MessageTypeEnum.IP.value());
        message.setMessage(curip);
        gtService.pushMessageToApp(JSON.toJSONString(message) );
    }
}
