package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_UserInfo;
import com.audit.janalysis.service.OBO_UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class OBO_UserInfoController {
    @Autowired
    private OBO_UserInfoService userInfoService;

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<OBO_UserInfo> getUserById(@PathVariable("id") String id) {
        OBO_UserInfo user = userInfoService.getUserInfo(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<OBO_UserInfo> addUser(@RequestBody OBO_UserInfo userInfo) {
        int result = userInfoService.addUser(userInfo);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userInfo);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<OBO_UserInfo> updateUser(@PathVariable("id") String id, @RequestBody OBO_UserInfo userInfo) {
        OBO_UserInfo existingUser = userInfoService.getUserInfo(id);
        if (existingUser != null) {
            userInfo.setUserId(Integer.valueOf(id));
            int result = userInfoService.updateUser(userInfo);
            if (result > 0) {
                return ResponseEntity.ok(userInfo);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        int result = userInfoService.deleteUser(id);
        if (result > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //获取用户信息
    @GetMapping("/getUserInfos")
    public ResponseEntity<List<OBO_UserInfo>> getUserInfos() {
        List<OBO_UserInfo> userInfos = userInfoService.getUserInfos();
        if (userInfos != null) {
            return ResponseEntity.ok(userInfos);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}

