package com.language.word.common.constant;

import java.util.HashMap;
import java.util.Map;

public class ReturnStatusConstant {

		/**
		 * 接口调用返回状态码
		 */
		public enum API_RETURN_STATUS {
		SERVER_SESSION_ERROR("-030102", "用户登陆失效，请重新登陆"),
			SERVER_INTERNAL_ERROR("-030101","服务器内部错误"),
			INVITE_SERVICE_ERROR("-030103", "邀请码系统异常"),
			VALIDATE_LOGO_SIZE_ERROR("-030104","图片大小超过1MB!"),
			NORMAL("0","正常"),
			PARA_ERROR("530001", "参数传递错误"),
			ENC_ERROR("530002", "ENC加密错误"),;

		private String value;
		private String desc;

		API_RETURN_STATUS(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String value() {
			return this.value;
		}

		public String desc() {
			return this.desc;
		}

		}
		public enum MESSAGE_STATUS {
		WAIT_READ(1, "待读取"), WAIT_SEND(5, "已推送"), READED(9, "已读取");

		private Integer value;
		private String desc;

		MESSAGE_STATUS(Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Integer value() {
			return this.value;
		}

		public String desc() {
			return this.desc;
		}

		public static String getDesc(Integer value) {
			for (MESSAGE_STATUS s : values()) {
				if (s.value == value) {
					return s.desc();
				}
			}
			return null;
		}

		public static Map<Integer, String> getMap() {
			Map<Integer, String> timeMap = new HashMap<Integer, String>();
			for (MESSAGE_STATUS s : values()) {
				timeMap.put(s.value, s.desc);
			}
			return timeMap;
		}
	}
}
