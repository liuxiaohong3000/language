package com.language.word.common.encryptor;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA {
	  //private static final String ALGORITHM = "RSA";
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	
	private static PublicKey getPublicKeyFromX509(String algorithm, String bysKey)
			throws NoSuchAlgorithmException, Exception {
		
		byte[] decodedKey = Base64.decode(bysKey);
	    X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);
	    
	    KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
	    return keyFactory.generatePublic(x509);
	}

	public static String encrypt(String content, String key) {
		try {
			PublicKey pubkey = getPublicKeyFromX509("RSA", key);
			
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(1, pubkey);

			byte[] plaintext = content.getBytes("UTF-8");
			byte[] output = cipher.doFinal(plaintext);

			String s = new String(Base64.encode(output));

			return s;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}

	public static String sign(String content, String privateKey) {
	    try {
	    	PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
	    	KeyFactory keyf = KeyFactory.getInstance("RSA");
	    	PrivateKey priKey = keyf.generatePrivate(priPKCS8);

	    	Signature signature = Signature.getInstance("SHA1WithRSA");
	    	signature.initSign(priKey);
	    	signature.update(content.getBytes("utf-8"));

	    	byte[] signed = signature.sign();

	    	return Base64.encode(signed);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return null;
	}
	
	public static boolean doCheck(String content, String sign, String publicKey) {
	    try {
	    	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    	byte[] encodedKey = Base64.decode(publicKey);
	    	PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

	    	Signature signature = Signature.getInstance("SHA1WithRSA");
	    	signature.initVerify(pubKey);
	    	signature.update(content.getBytes("utf-8"));

	    	boolean bverify = signature.verify(Base64.decode(sign));
	    	return bverify;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return false;
	 
	}

	public static String signUsingPKCS8(String content, String pkcs8FilePath) {
		
		File f = new File(pkcs8FilePath);
		FileInputStream is = null;
	    try {
	    	is = new FileInputStream(f);
	    	byte[] buffer = new byte[8192];
	    	int len = is.read(buffer);
	    	String privateStr = new String(buffer, 0, len);
	    	return sign(content, privateStr);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
	    		if (is != null) {
	    			is.close();
	    			is = null;
	    		}
	    	} catch (Exception e) {
		    	e.printStackTrace();
		    } 
	    }
	    
	    return "";
	}
	
	public static String signUsingPKCS8InputStream (String content, InputStream ins) {
		
	    try {
	    	byte[] buffer = new byte[8192];
	    	int len = ins.read(buffer);
	    	String privateStr = new String(buffer, 0, len);
	    	return sign(content, privateStr);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	
	    }
	    
	    return "";
	}
}
