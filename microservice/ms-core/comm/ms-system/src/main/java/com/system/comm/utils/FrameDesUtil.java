package com.system.comm.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * DES Class
 * @author Wujun
 * @version 1.0
 * @since 2013/03/11 1.0.0
 *
 */
public class FrameDesUtil {
	
	private static FrameDesUtil desUtil;
	
	private Key key;

	private FrameDesUtil() {
		setKey("12j3i3n3gy9a894");
	}
	public static synchronized FrameDesUtil getInstance() {
		if (desUtil == null)
			desUtil = new FrameDesUtil();
		return desUtil;
	}

	/**
	 * 根据参数生成KEY
	 */
	public void setKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		    DESKeySpec keySpec = new DESKeySpec(strKey.getBytes());
		    keyFactory.generateSecret(keySpec);

			//_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = keyFactory.generateSecret(keySpec);//_generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		}
	}

	/**
	 * 加密String明文输入,String密文输出
	 */
	public String encrypt(String string) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = string.getBytes("UTF8");
			byteMi = this.getEncCode(byteMing);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * @param strMi
	 * @return
	 */
	public String decrypt(String string) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(string);
			byteMing = this.getDesCode(byteMi);
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * @param byteS
	 * @return
	 */
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * @param byteD
	 * @return
	 */
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}
	
	public static void main(String args[]) {
		FrameDesUtil des = FrameDesUtil.getInstance();
		String str1 = "zjSEm6qdZ";
		//DES加密
		String str2 = des.encrypt(str1);
		//DES解密
		String deStr = des.decrypt(str2);
		System.out.println("密文:" + str2);
		System.out.println("明文:" + deStr);
		System.out.println(des.decrypt("+195FvoPPuhlBqihJdllXvcFQpP601iKpCCmc4mRQT5L18oHnf8eGXRv03l5Z9g2"));
		
	}
}
