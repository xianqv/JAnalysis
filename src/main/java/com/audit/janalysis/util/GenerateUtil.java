package com.audit.janalysis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GenerateUtil {

    private static final Logger LOGGER = LogManager.getLogger(GenerateUtil.class);

    //256位密钥生成
    public  void generateKey() throws NoSuchAlgorithmException, IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);  // 指定密钥长度
        SecretKey secretKey = keyGenerator.generateKey();
        LOGGER.info("密钥生成成功:{}",secretKey.getEncoded());
        FileUtils fileUtils = new FileUtils();
        fileUtils.saveKeyToFile(secretKey, "secretkey.bin");
    }

    //读取密钥
    public  SecretKey readKey() throws Exception {
        FileUtils fileUtils = new FileUtils();
        SecretKey secretKey = fileUtils.readKeyFromFile();
        return secretKey;
    }

}
