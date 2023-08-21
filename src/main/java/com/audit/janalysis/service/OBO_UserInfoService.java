package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_UserInfo;
import com.audit.janalysis.mapper.OBO_UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OBO_UserInfoService {
    @Autowired
    private OBO_UserInfoMapper userInfoMapper;

    // 获取用户信息
    public OBO_UserInfo getUserInfo(String userId) {
        return userInfoMapper.selectById(userId);
    }

    public int deleteUser(Integer id) {
        return userInfoMapper.deleteById(id);
    }

    public int updateUser(OBO_UserInfo userInfo) {
        return userInfoMapper.updateById(userInfo);
    }

    public int addUser(OBO_UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    public List<OBO_UserInfo> getUserInfos() {
        return userInfoMapper.selectList(null);
    }
}
