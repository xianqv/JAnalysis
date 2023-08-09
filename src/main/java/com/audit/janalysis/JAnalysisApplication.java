package com.audit.janalysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class JAnalysisApplication {


    private  static  final Logger LOGGER= LogManager.getLogger(JAnalysisApplication.class);
    public static void main(String[] args) throws IOException {
        SpringApplication.run(JAnalysisApplication.class, args);
        LOGGER.debug("debug message {}","log4j2debugmessage");
        LOGGER.info("info message {}","log4j2infomessage");
        LOGGER.warn("warn message {}","log4j2warnmessage");
        LOGGER.error("error message {}","log4j2errormessage");
        LOGGER.info("javaversion: {}", JavaVersion.getJavaVersion());



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
