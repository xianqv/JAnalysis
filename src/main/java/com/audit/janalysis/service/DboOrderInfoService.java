package com.audit.janalysis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.audit.janalysis.mapper.DboOrderInfoMapper;
import com.audit.janalysis.entity.DboOrderInfo;

import java.util.List;

@Service
public class DboOrderInfoService extends ServiceImpl<DboOrderInfoMapper, DboOrderInfo> {

    @Autowired
    private DboOrderInfoMapper dboOrderInfoMapper;

    // 查询订单信息
    public DboOrderInfo selectOrderInfo(String orderId) {
        return dboOrderInfoMapper.selectById(orderId);
    }
    //所有订单信息
    public List<DboOrderInfo> selectAllOrderInfo() {
        return dboOrderInfoMapper.selectList(null);
    }

    //删除订单信息
    public int deleteOrderInfo(String orderId) {
        return dboOrderInfoMapper.deleteById(orderId);
    }
}
