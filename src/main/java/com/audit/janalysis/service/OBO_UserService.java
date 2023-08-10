package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_User;
import com.audit.janalysis.mapper.OBO_UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OBO_UserService {
    @Autowired
    private OBO_UserMapper userMapper;

    public int insertUser(OBO_User obo_user) {
      return   userMapper.insert(obo_user);
    }

    public int updateUser(OBO_User obo_user ) {
        return userMapper.updateById(obo_user);
    }

    public OBO_User getUser(String user_id) {
        return userMapper.selectById(user_id);
    }

    public List<OBO_User> findAll() {
        return userMapper.selectList(null);
    }

    public int deleteUser(String user_id) {
        return  userMapper.deleteById(user_id);
    }
    public Page<OBO_User> getUsersByPage(int pageNum, int pageSize) {
        Page<OBO_User> page = new Page<>(pageNum, pageSize); // 创建分页对象
        userMapper.selectPage(page, null); // 使用 selectPage 方法进行分页查询
        return page;
    }


}
