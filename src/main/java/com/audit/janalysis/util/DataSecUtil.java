package com.audit.janalysis.util;


import org.springframework.stereotype.Service;


import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

import java.util.Base64;


@Service
public class DataSecUtil {

    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int IV_LENGTH_BYTE = 12;
    private static final int TAG_LENGTH_BIT = 128;




    //AES/GCM/PKCS5Padding 解密
    public String aesDecrypt(String content, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        byte[] ivBytes = new byte[IV_LENGTH_BYTE];
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(content);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


    //AES/GCM/PKCS5Padding 加密
    public  String aesEncrypt(String content, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        byte[] ivBytes = new byte[IV_LENGTH_BYTE];
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
