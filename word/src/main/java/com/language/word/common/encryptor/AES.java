package com.language.word.common.encryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static String secretKey = "";
	
	public static String encode (String str) {
		byte[] raw = secretKey.getBytes();
		SecretKeySpec key = new SecretKeySpec(raw, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byteContent = str.getBytes("utf-8");
			byte[] encrypted = cipher.doFinal(byteContent);
			return Base64.encode(encrypted);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public AES() {

	}

}
