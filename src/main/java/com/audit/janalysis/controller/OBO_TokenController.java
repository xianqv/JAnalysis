package com.audit.janalysis.controller;

import com.audit.janalysis.entity.OboToken;
import com.audit.janalysis.service.OboTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/token")
public class OBO_TokenController {
    @Autowired
    OboTokenService oboTokenService;

        @GetMapping ("/createToken/{userid}")
        public OboToken createToken(@PathVariable("userid") String userid){
            OboToken oboToken =new OboToken();
            String clientId = "cid"+UUID.randomUUID().toString();
            // 过期时间
            int expiresIn = 3600;
            String tokenValue = UUID.randomUUID().toString();
            oboToken.setUser_id(Long.valueOf(userid));
            oboToken.setToken_value(tokenValue);
            oboToken.setClient_id(clientId);
            oboToken.setDelegation_user_id(clientId);
            oboToken.setExpires_in(expiresIn);
            oboToken.setCreated_at(Instant.now().toEpochMilli());
            oboToken.setUpdated_at(Instant.now().toEpochMilli());
            oboTokenService.createToken(oboToken);
            return oboToken;
        }

        @GetMapping("/{tokenId}")
        public String getToken(@PathVariable("tokenId") Long tokenId) {
            // 根据令牌ID查询令牌信息并返回
            // 实现逻辑略
            return "Token information for tokenId: " + tokenId;
        }

        @PutMapping("/{tokenId}")
        public String updateToken(@PathVariable("tokenId") Long tokenId) {
            // 根据令牌ID更新令牌信息
            // 实现逻辑略
            return "Token updated successfully for tokenId: " + tokenId;
        }

        @DeleteMapping("/{tokenId}")
        public String deleteToken(@PathVariable("tokenId") Long tokenId) {
            // 根据令牌ID删除令牌信息
            // 实现逻辑略
            return "Token deleted successfully for tokenId: " + tokenId;
        }



}
