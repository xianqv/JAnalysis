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
@TableName(value = "JAnalysis.DBO_OrderInfo")
public class DboOrderInfo {
    @TableId(value = "order_id", type = IdType.INPUT)
    private Integer order_id;

    @TableField(value = "user_id")
    private Integer user_id;

    @TableField(value = "order_date")
    private Date order_date;

    @TableField(value = "total_amount")
    private BigDecimal total_amount;

    @TableField(value = "shipping_address")
    private String shipping_address;

    @TableField(value = "shipping_city")
    private String shipping_city;

    @TableField(value = "shipping_country")
    private String shipping_country;

    @TableField(value = "shipping_postal_code")
    private String shipping_postal_code;

    @TableField(value = "payment_method")
    private String payment_method;

    @TableField(value = "transaction_id")
    private String transaction_id;

    @TableField(value = "is_paid")
    private Boolean is_paid;

    @TableField(value = "is_shipped")
    private Boolean is_shipped;

    @TableField(value = "shipping_date")
    private Date shipping_date;

    @TableField(value = "delivery_date")
    private Date delivery_date;

    @TableField(value = "special_instructions")
    private String special_instructions;
}