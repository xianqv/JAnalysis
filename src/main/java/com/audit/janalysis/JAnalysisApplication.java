package com.audit.janalysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;

@SpringBootApplication
public class JAnalysisApplication {


    private  static  final Logger LOGGER= LogManager.getLogger(JAnalysisApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(JAnalysisApplication.class, args);
        LOGGER.debug("debug message {}","log4j2debugmessage");
        LOGGER.info("info message {}","log4j2infomessage");
        LOGGER.warn("warn message {}","log4j2warnmessage");
        LOGGER.error("error message {}","log4j2errormessage");
        LOGGER.info("javaversion: {}", JavaVersion.getJavaVersion());
    }

}
