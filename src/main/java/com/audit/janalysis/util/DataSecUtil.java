package com.audit.janalysis.util;


import org.springframework.stereotype.Service;


import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import java.util.Base64;


@Service
public class DataSecUtil {

    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int IV_LENGTH_BYTE = 12;
    private static final int TAG_LENGTH_BIT = 128;
    private static final int BUFFER_SIZE = 8192;  // 设置缓冲区大小为 8192 字节




    //AES/GCM/PKCS5Padding 解密
    public String aesDecrypt(String content, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        byte[] ivBytes = new byte[IV_LENGTH_BYTE];
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(content);
        byte[] decryptedBytes = decryptWithBuffer(cipher,encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


    //AES/GCM/PKCS5Padding 加密
    public  String aesEncrypt(String content, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        byte[] ivBytes = new byte[IV_LENGTH_BYTE];
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedBytes = encryptWithBuffer(cipher,content.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static byte[] encryptWithBuffer(Cipher cipher, byte[] inputData) throws Exception {
        // 计算加密后的数据长度
        int encryptedSize = cipher.getOutputSize(inputData.length);

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(Math.max(encryptedSize, BUFFER_SIZE));

        // 加密数据
        int offset = 0;
        while (offset < inputData.length) {
            int length = Math.min(BUFFER_SIZE, inputData.length - offset);
            byte[] inputBuffer = new byte[length];
            System.arraycopy(inputData, offset, inputBuffer, 0, length);

            byte[] outputBuffer = cipher.update(inputBuffer);
            buffer.put(outputBuffer);

            offset += length;
        }

        byte[] finalBuffer = cipher.doFinal();
        buffer.put(finalBuffer);

        // 提取加密后的数据
        buffer.flip();
        byte[] encryptedData = new byte[buffer.remaining()];
        buffer.get(encryptedData);

        return encryptedData;
    }




    private static byte[] decryptWithBuffer(Cipher cipher, byte[] encryptedData) throws Exception {
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(Math.max(encryptedData.length, BUFFER_SIZE));

        // 解密数据
        int offset = 0;
        while (offset < encryptedData.length) {
            int length = Math.min(BUFFER_SIZE, encryptedData.length - offset);
            byte[] inputBuffer = new byte[length];
            System.arraycopy(encryptedData, offset, inputBuffer, 0, length);

            byte[] outputBuffer = cipher.update(inputBuffer);
            buffer.put(outputBuffer);

            offset += length;
        }

        byte[] finalBuffer = cipher.doFinal();
        buffer.put(finalBuffer);

        // 提取解密后的数据
        buffer.flip();
        byte[] decryptedData = new byte[buffer.remaining()];
        buffer.get(decryptedData);

        return decryptedData;
    }



}
