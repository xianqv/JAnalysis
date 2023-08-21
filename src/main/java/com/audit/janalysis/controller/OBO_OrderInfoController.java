package com.audit.janalysis.controller;

import com.audit.janalysis.entity.DboOrderInfo;
import com.audit.janalysis.service.DboOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderinfo")
public class OBO_OrderInfoController {


        @Autowired
        private DboOrderInfoService dboOrderInfoService;

        // 查询订单信息
        @GetMapping("/{orderId}")
        public ResponseEntity<DboOrderInfo> getOrderInfo(@PathVariable String orderId) {
            DboOrderInfo orderInfo = dboOrderInfoService.selectOrderInfo(orderId);
            if (orderInfo != null) {
                return ResponseEntity.ok(orderInfo);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // 获取所有订单信息
        @GetMapping("/all")
        public ResponseEntity<List<DboOrderInfo>> getAllOrderInfo() {
            List<DboOrderInfo> orderInfoList = dboOrderInfoService.selectAllOrderInfo();
            if (!orderInfoList.isEmpty()) {
                return ResponseEntity.ok(orderInfoList);
            } else {
                return ResponseEntity.noContent().build();
            }
        }

        // 删除订单信息
        @DeleteMapping("/{orderId}")
        public ResponseEntity<String> deleteOrderInfo(@PathVariable String orderId) {
            int result = dboOrderInfoService.deleteOrderInfo(orderId);
            if (result > 0) {
                return ResponseEntity.ok("Order info deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        }


}
