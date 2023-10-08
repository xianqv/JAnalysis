package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_User;
import com.audit.janalysis.entity.OboToken;
import com.audit.janalysis.service.OBO_UserService;
import com.audit.janalysis.util.DataSecUtil;
import com.audit.janalysis.util.GenerateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import java.util.List;

@RestController
public class OBO_UserController {
    private static final Logger LOGGER = LogManager.getLogger(OBO_UserController.class);

    @Autowired
    OBO_UserService obo_userService;
    @Autowired
    DataSecUtil dataSecUtil;
    @Autowired
    OBO_TokenController oboTokenController;

    @GetMapping (value =  "/getUserInfos")
    public ResponseEntity<List> getUserInfos() throws Exception {
        List<OBO_User> userList=obo_userService.findAll();
        for (OBO_User user : userList) {
            // 获取每个用户对象的属性并进行处理
            String password = user.getPassword();
            GenerateUtil generateUtil =new GenerateUtil();
            SecretKeySpec key = (SecretKeySpec) generateUtil.readKey();
            String password2=dataSecUtil.aesDecrypt(password,key);
            user.setPassword(password2);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping(value = "/getUserInfo/{userId}")
    public OBO_User getUserInfo(@PathVariable("userId") String userId) throws Exception {
        LOGGER.info("获取用户信息");
        OBO_User user = obo_userService.getUser(userId);
        GenerateUtil generateUtil =new GenerateUtil();
        SecretKeySpec key = (SecretKeySpec) generateUtil.readKey();
        user.setPassword(dataSecUtil.aesDecrypt(user.getPassword(),key));
        LOGGER.info("获取用户信息成功" + user);
        LOGGER.info("获取用户信息成功:"+"解密明文密码:"+dataSecUtil.aesDecrypt(user.getPassword(),key));
        return user;
    }

    @PostMapping(value="/deleteUser")
    public void deleteUser(@RequestParam("userId") String userId) {
        LOGGER.info("删除用户信息");
        int flag = obo_userService.deleteUser(userId);
        LOGGER.info("删除用户信息成功" + flag);
    }


    @PostMapping(value="/updateUser")
    public void updateUser(@RequestBody OBO_User user) throws Exception {
        GenerateUtil generateUtil =new GenerateUtil();
        SecretKeySpec key = (SecretKeySpec) generateUtil.readKey();
        user.setPassword(dataSecUtil.aesEncrypt(user.getPassword(),key));
        LOGGER.info("更新用户信息");
        int flag = obo_userService.updateUser(user);
        LOGGER.info("更新用户信息成功" + flag);
    }

    @PostMapping(value="/addUser")
    public void addUser(@RequestBody OBO_User user) throws Exception {
        GenerateUtil generateUtil =new GenerateUtil();
        SecretKeySpec key = (SecretKeySpec) generateUtil.readKey();
        user.setPassword(dataSecUtil.aesEncrypt(user.getPassword(),key));
        int flag = obo_userService.insertUser(user);
        LOGGER.info("用户注册成功" + flag);
    }

    @PostMapping(value="/userLogin")
    public ResponseEntity<String> userLogin(@RequestParam("userName") String userName ,@RequestParam("password") String password) throws Exception {
        LOGGER.info("用户登录");
        OBO_User user = obo_userService.getUserByName(userName);
        if(user==null){
            LOGGER.info("用户不存在");
            return null;
        }
        //密码解密
        GenerateUtil generateUtil =new GenerateUtil();
        SecretKeySpec key = (SecretKeySpec) generateUtil.readKey();
        String userPassword = dataSecUtil.aesDecrypt(user.getPassword(),key);
        if(!userPassword.equals(password)){
            LOGGER.info("密码错误");
            return null;
        }
        //token
        OboToken oboToken=oboTokenController.createToken(String.valueOf(user.getId()));

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(oboToken.getToken_value());
        headers.setCacheControl("no-cache, no-store, max-age=0, must-revalidate");
        headers.setPragma("no-cache");
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info("用户登录成功" + user);
        // 返回令牌
        return new ResponseEntity<>("create token success", headers,HttpStatus.OK);
    }

}
