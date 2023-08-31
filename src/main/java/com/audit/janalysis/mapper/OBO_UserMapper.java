package com.audit.janalysis.mapper;

import com.audit.janalysis.entity.OBO_User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OBO_UserMapper extends BaseMapper<OBO_User> {
    OBO_User selectOne(String username);

}
