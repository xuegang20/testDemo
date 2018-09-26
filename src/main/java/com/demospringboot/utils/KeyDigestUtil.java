/*
 * Copyright (c) 2017.版权所有
 */

package com.demospringboot.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * 加密工具类
 * Created by yx on 2016/12/6.
 */
public class KeyDigestUtil {
    private static final String HMAC_SHA1 = "HmacSHA1";

    //用户密码加密
    public static String encryptByMD5(String password) {
        DigestUtils du = new DigestUtils();
        String newpassword = DigestUtils.md5Hex(DigestUtils.md5Hex(password));
        return newpassword;
    }

    /**
     * hamcSHA1 Base64签名加密
     *
     * @param data 待加密的数据
     * @param key  加密使用的key
     * @throws java.security.InvalidKeyException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static String hmacSHA1AndBase64(String data, String key) throws Exception {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), HMAC_SHA1);//加密密钥
        Mac localMac = Mac.getInstance(HMAC_SHA1);
        localMac.init(localSecretKeySpec);
        localMac.update(data.getBytes("UTF-8"));//加密内容，这里使用时间
        byte[] bt = localMac.doFinal();
//        com.sun.org.apache.xml.internal.security.utils.Base64.encode(bt);
        return new String(Base64.encodeBase64(bt));
    }

    // 加密
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
