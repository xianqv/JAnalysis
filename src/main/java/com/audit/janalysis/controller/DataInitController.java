package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OBO_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DataInitController {

    @Autowired
    OBO_UserController oboUserController;

    //插入10W条数据

    @PutMapping("/insertDat10W")
    public void insertDat10W() throws Exception {
        List<OBO_User> userList = new ArrayList<>();


        for (int i = 0; i < 100000; i++) {
            OBO_User user = generateRandomUser();
            userList.add(user);
        }

        // 打印生成的用户列表
        for (OBO_User user : userList) {
           oboUserController.addUser(user);
        }
    }

    private static int generateUniqueID(Random random, Set<Integer> idSet) {
            int id;
            do {
                id = random.nextInt(Integer.MAX_VALUE);
            } while (idSet.contains(id));
            idSet.add(id);
            return id;

    }


    private static OBO_User generateRandomUser() {
        Random random = new Random();
        Set<Integer> idSet = new HashSet<>();
        // 生成随机属性值
        int id = generateUniqueID(random, idSet);
        String username = generateRandomString(8);
        String password = generateRandomString(12);
        String email = generateRandomString(10) + "@example.com";

        return new OBO_User(id, username, password, email);
    }
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

}
