package com.audit.janalysis.service;

import com.audit.janalysis.mapper.DboProductInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.audit.janalysis.entity.DboProductInfo;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DboProductInfoService  {
    private static final Logger LOGGER = LogManager.getLogger(DboOrderInfoService.class);

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


    public void updateProductInfo() {

        //更新商品信息
        QueryWrapper<DboProductInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", 6);
        int id;
        DboProductInfo productInfo1 = dboProductInfoMapper.selectOne(wrapper);
        DboProductInfo productInfo2 = dboProductInfoMapper.selectOne(wrapper);

        id = productInfo2.getProduct_id();
        productInfo1.setPrice(productInfo1.getPrice().add(BigDecimal.valueOf(100)));
        dboProductInfoMapper.updateById(productInfo1);

        productInfo2.setPrice(productInfo2.getPrice().subtract(BigDecimal.valueOf(50)));
        int result = dboProductInfoMapper.updateById(productInfo2);
        if (result == 0) {
            DboProductInfo productInfo3 = dboProductInfoMapper.selectById(productInfo2.getProduct_id());
            productInfo3.setPrice(productInfo3.getPrice().subtract(BigDecimal.valueOf(50)));
            dboProductInfoMapper.updateById(productInfo3);
        }
        DboProductInfo productInfo4 = dboProductInfoMapper.selectById(id);
        LOGGER.info("当前库存为{}", productInfo4.getPrice());
    }
}
