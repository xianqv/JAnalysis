package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_User;
import com.audit.janalysis.service.OBO_UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OBO_UserController {
    private static final Logger LOGGER = LogManager.getLogger(OBO_UserController.class);

    @Autowired
    OBO_UserService obo_userService;

    @GetMapping (value =  "/getUserInfos")
    public List getUserInfos() {

        LOGGER.info("获取用户信息");
        List<OBO_User> userList=obo_userService.findAll();
        LOGGER.info("获取用户信息成功"+userList.size()+"个用户:"+userList);
        return userList;
    }


    @PostMapping(value = "/getUserInfo")
    public OBO_User getUserInfo(@RequestParam("userId") String userId) {
        LOGGER.info("获取用户信息");
        OBO_User user = obo_userService.getUser(userId);
        LOGGER.info("获取用户信息成功" + user);
        return user;
    }

    @PostMapping(value="/deleteUser")
    public void deleteUser(@RequestParam("userId") String userId) {
        LOGGER.info("删除用户信息");
        int flag = obo_userService.deleteUser(userId);
        LOGGER.info("删除用户信息成功" + flag);
    }


    @PostMapping(value="/updateUser")
    public void updateUser(@RequestBody OBO_User user) {
        LOGGER.info("更新用户信息");
        int flag = obo_userService.updateUser(user);
        LOGGER.info("更新用户信息成功" + flag);
    }

    @PostMapping(value="/addUser")
    public void addUser(@RequestBody OBO_User user) {
        LOGGER.info("添加用户信息");
        int flag = obo_userService.insertUser(user);
        LOGGER.info("添加用户信息成功" + flag);
    }


}
