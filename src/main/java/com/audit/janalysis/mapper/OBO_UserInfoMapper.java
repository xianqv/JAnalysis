package com.audit.janalysis.mapper;

import com.audit.janalysis.entity.OBO_UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Resource
@Mapper
@Repository
public interface OBO_UserInfoMapper extends BaseMapper<OBO_UserInfo> {
}
