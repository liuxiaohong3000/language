package com.language.word.service.webservice;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.language.word.common.config.GTSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 个推工具类
 * 
 * @Desc:
 * @Author:liuxiaohong
 * @Since:2017年5月15日
 * @Version:1.0
 */
@Service("gtService")
public class GTService {
    private static Logger logger = LoggerFactory.getLogger(GTService.class);
    private static Integer offLineTime = 24 * 3600 * 1000;
    // 定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
	@Autowired
	private GTSourceProperties gtSourceProperties;

	/**
	 * 推送指定的客户端
	 * @param clientId
	 * @param content
	 * @return
	 * @throws IOException
	 */
    public Boolean pushMessageToClient( String clientId, String content) throws IOException {
		return pushMessageToAndroidClient(clientId, content);

	}

    /**
     * @param clientId
     * @param content
     * @return
     * @throws IOException
     * @Desc:安卓在线正常，离线收不到了,只有打开app后才能收到
     */
    private Boolean pushMessageToAndroidClient(String clientId, String content)
	    throws IOException {

	IGtPush push = new IGtPush(gtSourceProperties.getUrl(), gtSourceProperties.getAppKey(), gtSourceProperties.getMasterSecret());
	TransmissionTemplate template = new TransmissionTemplate();
	template.setAppId(gtSourceProperties.getAppId());
	template.setAppkey(gtSourceProperties.getAppKey());
	// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	template.setTransmissionType(2);
	template.setTransmissionContent(content);

	SingleMessage message = new SingleMessage();
	message.setOffline(true);
	// 离线有效时间，单位为毫秒，可选
	message.setOfflineExpireTime(offLineTime);
	message.setData(template);
	// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
	message.setPushNetWorkType(0);
	Target target = new Target();
	target.setAppId(gtSourceProperties.getAppId());
	target.setClientId(clientId);
	IPushResult ret = null;
	try {
	    ret = push.pushMessageToSingle(message, target);
	} catch (RequestException e) {
	    e.printStackTrace();
	    try {
		ret = push.pushMessageToSingle(message, target);
	    } catch (RequestException re) {
		re.printStackTrace();
	    }
	}
	if (ret != null) {
	    System.out.println(ret.getResponse().toString());
	    return true;
	} else {
	    logger.info(String.format("clientId:%s，content：%s，服务器异常了", clientId, content));
	}
	return false;
    }

	/**
	 * 推送app
	 * @param content
	 * @return
	 * @throws IOException
	 */
	public Boolean pushMessageToApp(String content) throws IOException {
		return pushMessageToAndroidApp(content);

	}

	/**
	 * @param content
	 * @return
	 * @throws IOException
	 * @Desc:安卓在线正常，离线收不到了,只有打开app后才能收到
	 */
	private Boolean pushMessageToAndroidApp(String content)
			throws IOException {

		IGtPush push = new IGtPush(gtSourceProperties.getUrl(), gtSourceProperties.getAppKey(), gtSourceProperties.getMasterSecret());
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(gtSourceProperties.getAppId());
		template.setAppkey(gtSourceProperties.getAppKey());
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		template.setTransmissionContent(content);

		AppMessage message = new AppMessage ();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(offLineTime);
		message.setData(template);
		// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
		message.setPushNetWorkType(0);

		//推送给App的目标用户需要满足的条件
		List<String> appIdList = new ArrayList<String>();
		appIdList.add(gtSourceProperties.getAppId());
		message.setAppIdList(appIdList);

		IPushResult ret = null;
		try {
			ret = push.pushMessageToApp(message);
		} catch (RequestException e) {
			e.printStackTrace();
			try {
				ret = push.pushMessageToApp(message);
			} catch (RequestException re) {
				re.printStackTrace();
			}
		}
		if (ret != null) {
			System.out.println(ret.getResponse().toString());
			return true;
		} else {
			logger.info(String.format("content：%s，服务器异常了", content));
		}
		return false;
	}
}
