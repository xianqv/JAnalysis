package com.audit.janalysis.util;

import org.springframework.web.multipart.MultipartFile;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;

public class FileUtils {


    // 保存密钥到文件
    public  void saveKeyToFile(Key key, String filename) throws IOException {
        byte[] encodedKey = key.getEncoded();
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(encodedKey);
        outputStream.close();
    }

    //读取密钥
    public SecretKey readKeyFromFile() throws Exception {
        FileInputStream inputStream = new FileInputStream("secretkey.bin");
        byte[] encodedKey = new byte[inputStream.available()];
        inputStream.read(encodedKey);
        inputStream.close();
        return new SecretKeySpec(encodedKey, "AES");
    }

}