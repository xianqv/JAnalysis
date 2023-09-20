package com.audit.janalysis.controller;

import com.audit.janalysis.entity.DboProductInfo;
import com.audit.janalysis.service.DboProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productinfo")
public class OBO_ProductInfoController {



        @Autowired
        private DboProductInfoService dboProductInfoService;

        // 查询所有产品信息
        @GetMapping("/all")
        public ResponseEntity<List<DboProductInfo>> getProductInfos() {
            List<DboProductInfo> productInfoList = dboProductInfoService.getProductInfos();
            if (!productInfoList.isEmpty()) {
                return ResponseEntity.ok(productInfoList);
            } else {
                return ResponseEntity.noContent().build();
            }
        }

        // 查询单个产品信息
        @GetMapping("/{productId}")
        public ResponseEntity<DboProductInfo> getProductInfo(@PathVariable String productId) {
            DboProductInfo productInfo = dboProductInfoService.getProductInfo(productId);
            if (productInfo != null) {
                return ResponseEntity.ok(productInfo);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // 新增产品信息
        @PostMapping("/")
        public ResponseEntity<String> addProductInfo(@RequestBody DboProductInfo dboProductInfo) {
            int result = dboProductInfoService.addProductInfo(dboProductInfo);
            if (result > 0) {
                return ResponseEntity.ok("Product info added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        // 更新产品信息
        @PutMapping("/")
        public ResponseEntity<String> updateProductInfo(@RequestBody DboProductInfo dboProductInfo) {
            int result = dboProductInfoService.updateProductInfo(dboProductInfo);
            if (result > 0) {
                return ResponseEntity.ok("Product info updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // 删除产品信息
        @DeleteMapping("/{productId}")
        public ResponseEntity<String> deleteProductInfo(@PathVariable String productId) {
            int result = dboProductInfoService.deleteProductInfo(productId);
            if (result > 0) {
                return ResponseEntity.ok("Product info deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @GetMapping("/threads")
        public void threadsUpdate(){
            dboProductInfoService.updateProductInfo();
        }


}
