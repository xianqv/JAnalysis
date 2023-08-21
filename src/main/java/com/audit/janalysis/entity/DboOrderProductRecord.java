package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName(value = "JAnalysis.DBO_Order_Product_Record")
public class DboOrderProductRecord {
    @TableId(value = "record_id", type = IdType.INPUT)
    private Integer record_id;

    @TableField(value = "order_id")
    private Integer order_id;

    @TableField(value = "product_id")
    private Integer product_id;

    @TableField(value = "user_id")
    private Integer user_id;

    @TableField(value = "quantity")
    private Integer quantity;

    @TableField(value = "unit_price")
    private BigDecimal unit_price;

    @TableField(value = "total_price")
    private BigDecimal total_price;

    @TableField(value = "discount")
    private BigDecimal discount;

    @TableField(value = "tax")
    private BigDecimal tax;

    @TableField(value = "shipping_fee")
    private BigDecimal shipping_fee;

    @TableField(value = "returned")
    private Boolean returned;

    @TableField(value = "return_reason")
    private String return_reason;

    @TableField(value = "return_date")
    private Date return_date;
}