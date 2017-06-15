package com.language.word.job;

import com.language.word.common.constant.StatusEnum;
import com.language.word.model.BIp;
import com.language.word.service.busservice.BusClientService;
import com.language.word.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Administrator on 2017/6/5.
 */
//@Component
//@EnableScheduling // 启用定时任务
public class IpCheckSchedule {


    @Autowired
    private BusClientService busClientService;

    @Scheduled(fixedDelay  = 5000)
    public void fixedRateJob() {

        try{
            //当前IP
            String curip= IpUtil.getLocalHostAddr();

            //数据库有效IP
            BIp ip=busClientService.queryValidIp();

            if(ip==null){
                //推送消息
                busClientService.pushMessage(curip);

                //新增IP
                busClientService.saveValidIp(curip);

                System.out.println("[ip is null ,new ip is :"+curip+" ]");
                return ;
            }
            //如果IP变化了，更新数据库
            if(!ip.getIp().equals(curip)){
                System.out.println("[ip change, old ip is :"+ip.getIp()+" ,new ip is : "+curip+" ]");

                ip.setStatus(StatusEnum.invalid.value());
                busClientService.modifyIp(ip);

                //推送消息
                busClientService.pushMessage(curip);

                //新增IP
                busClientService.saveValidIp(curip);

                return ;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
