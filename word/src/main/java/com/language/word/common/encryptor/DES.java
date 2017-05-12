package com.language.word.common.encryptor;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {

	SecretKeySpec _key = null;
	private static byte[] _iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public DES() {

	}

	public DES(String str) {
		setKey(str);
	}

	public Key key() {
		return _key;
	}

	public void key(SecretKeySpec _key) {
		this._key = _key;
	}

	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 根据参数生成 KEY
	 */
	public void setKey(String strKey) {
		try {
			this.key( new SecretKeySpec(strKey.getBytes("utf-8"), "DES") );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密 String 明文输入 ,String 密文输出
	 */
	public String encryptStr(String plainString) {

		try {
			//System.out.println("origin string:" + plainString);
			//System.out.println("string to utf8 byte:" + parseByte2HexStr(plainString.getBytes("UTF8")));
			byte[] encryptedData = encryptByte(plainString.getBytes("UTF8"));
			//System.out.println("desed byte:" + parseByte2HexStr(encryptedData));
			//System.out.println("base64 string:" + Base64.encode(encryptedData));
			return Base64.encode(encryptedData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return null;

	}

	/**
	 * 解密 以 String 密文输入 ,String 明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String decryptStr(String encryptString) {
		try {
			byte[] decryptData = decryptByte(Base64.decode(encryptString));
			return new String(decryptData, "UTF8");
		} catch (Exception e) {
//			System.out.println("not a des string:" + encryptString);
		} finally {
			
		}
		return null;
	}

	/**
	 * 加密以 byte[] 明文输入 ,byte[] 密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] encryptByte(byte[] byteS) {
		IvParameterSpec zeroIv = new IvParameterSpec(_iv);
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, this.key(), zeroIv);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			zeroIv = null;
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以 byte[] 密文输入 , 以 byte[] 明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] decryptByte(byte[] byteD) {
		IvParameterSpec zeroIv = new IvParameterSpec(_iv);
		Cipher cipher = null;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, this.key(), zeroIv);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			zeroIv = null;
			cipher = null;
		}
		return byteFina;
	}

	public static void main(String[] args) throws Exception {
		DES des = new DES("12345678");

		String str = "中文abc12";
		String enStr = des.encryptStr(str);
		String deStr = des.decryptStr(enStr);

		System.out.println("加密前: " + str);
		System.out.println("加密后: " + enStr);
		System.out.println("解密后: " + deStr);
	}

}
