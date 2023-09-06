package com.audit.janalysis;

import com.audit.janalysis.util.DataSecUtil;
import com.audit.janalysis.util.GenerateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class JAnalysisApplication {


    private  static  final Logger LOGGER= LogManager.getLogger(JAnalysisApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JAnalysisApplication.class, args);
        LOGGER.debug("debug message {}","log4j2debugmessage");
        LOGGER.info("info message {}","log4j2infomessage");
        LOGGER.warn("warn message {}","log4j2warnmessage");
        LOGGER.error("error message {}","log4j2errormessage");
        LOGGER.info("javaversion: {}", JavaVersion.getJavaVersion());

        DataSecUtil dataSecUtil=new DataSecUtil();
        GenerateUtil generateUtil =new GenerateUtil();


        SecretKey key =generateUtil.readKey();
        String content="hello world";

        //加密
        String text=dataSecUtil.aesEncrypt(content, (SecretKeySpec) key);
        LOGGER.info("加密后内容：{}",text);
        String text2=dataSecUtil.aesDecrypt(text, (SecretKeySpec) key);
        LOGGER.info("解密后内容：{}",text2);

        File src = new File("./src_file");
        File dest = new File("./src_file2");

//        try {
//            copydir(src,dest);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }


    public static void copydir(File src, File dst) throws IOException {
        dst.mkdirs();
        File[] files = src.listFiles();
        LOGGER.info(files);
        if (files.length==0||files==null){
            LOGGER.info("files 无访问权限:{}",files );
        }

        for (File file : files) {
            if (file.isFile()) {
                int len = 0;
                byte[] bytes = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dst, file.getName()));

                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                copydir(file, new File(dst, file.getName()));
            }


        }

    }

}
