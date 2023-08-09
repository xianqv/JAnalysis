package com.audit.janalysis.controller;

import cn.hutool.core.util.ZipUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class FileReceiverController {


    private static final Logger LOGGER = LogManager.getLogger(FileReceiverController.class);

    @PostMapping(value = "/fileReceiver",consumes = "multipart/form-data")
    public  void receiveFile(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
        LOGGER.info("上传文件信息：类型:{},文件名:{},大小:{}kb", multipartFile.getContentType(), multipartFile.getOriginalFilename(), multipartFile.getSize() / 1024);
        //解压zip文件
        if (multipartFile.getContentType().startsWith("application/zip")) {
            LOGGER.info("存储并解压缩文件");
            // unzip the file
            multipartFile.transferTo(new File("/Users/haigangdeng/Documents/IdeaProject/unzip/" + multipartFile.getOriginalFilename()));

            ZipUtil.unzip("/Users/haigangdeng/Documents/IdeaProject/unzip/"+multipartFile.getOriginalFilename(),
                                    "/Users/haigangdeng/Documents/IdeaProject/unzip/"+multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().lastIndexOf(".")));

        }


    }


}
