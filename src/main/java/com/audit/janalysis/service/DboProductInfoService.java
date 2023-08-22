package com.audit.janalysis.service;

import com.audit.janalysis.mapper.DboProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.audit.janalysis.entity.DboProductInfo;

import java.util.List;

@Service
public class DboProductInfoService  {

    @Autowired
    DboProductInfoMapper dboProductInfoMapper;

    // 查询产品信息
    public List<DboProductInfo> getProductInfos() {
        return dboProductInfoMapper.selectList(null);
    }

    // 查询产品信息
    public DboProductInfo getProductInfo(String productId) {
        return dboProductInfoMapper.selectById(productId);
    }

    // 新增产品信息
    public int addProductInfo(DboProductInfo dboProductInfo) {
        return  dboProductInfoMapper.insert(dboProductInfo);
    }

    // 更新产品信息
    public int updateProductInfo(DboProductInfo dboProductInfo) {
        return  dboProductInfoMapper.updateById(dboProductInfo);
    }

    // 删除产品信息
    public int deleteProductInfo(String id) {
        return  dboProductInfoMapper.deleteById(id);
    }
}
