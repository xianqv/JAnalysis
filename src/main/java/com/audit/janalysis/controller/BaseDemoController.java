package com.audit.janalysis.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.system.JavaVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDate;

@RestController
public class BaseDemoController {

    private static final Logger LOGGER = LogManager.getLogger(BaseDemoController.class);
    @GetMapping(value = "/soutbase")
    public void soutBase(){
        LOGGER.info(LocalDate.now()); // For logging only.
        LOGGER.info(LocalDate.of(1992,12,07));
        LOGGER.info(LocalDate.now().getDayOfMonth() + " " + LocalDate.now().getMonthValue() + " " + LocalDate.now().getYear());
        LOGGER.info(LocalDate.now().plusDays(100));
        LOGGER.info(LocalDate.now().plusMonths(1));
        LOGGER.info(LocalDate.now().plusYears(1));
        LOGGER.info(LocalDate.now().getDayOfWeek().getValue());
        LOGGER.info(LocalDate.now().isLeapYear());
    }


    @GetMapping("/iobase")
    public void ioBase() throws IOException {
        LOGGER.info("-------向文件中写内容------");
        LOGGER.info("-------创建文件------：{}","./file.txt");
        FileOutputStream fos =new FileOutputStream("./file.txt",true);
        LOGGER.info("--------ioBase写入内容------");
        fos.write("Hello World!".getBytes());
        fos.write(97);
        fos.write(JavaVersion.getJavaVersion().toString().getBytes());
        fos.close();
        LOGGER.info("-------写入完成关闭流-----");


        LOGGER.info("-------读取文件内容------：{}","./file.txt");
        FileInputStream fis =new FileInputStream("./file.txt");
        int b= 0;
        while((b=fis.read())!=-1){
            LOGGER.info("文件内容：{}",(char)b);
        }
        LOGGER.info("-------读取成功------");
        fis.close();
    }


    @GetMapping(value = "/filecopy")
    public  void filecopy() throws IOException {
        FileInputStream fis=new FileInputStream("./1.jpg");
        FileOutputStream fos=new FileOutputStream("./2.jpg");
        byte[] b = new byte[1024];
        int len = 0;
        while((len = fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fis.close();
        fos.close();
    }

    @GetMapping(value = "/buffercopy")
    public  void buffercopy() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./1.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./2.jpg"));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        bis.close();
        bos.close();
    }




}
