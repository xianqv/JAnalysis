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
@TableName(value = "JAnalysis.DBO_ProductInfo")
public class DboProductInfo {
    @TableId(value = "product_id", type = IdType.INPUT)
    private Integer product_id;

    @TableField(value = "product_name")
    private String product_name;

    @TableField(value = "category")
    private String category;

    @TableField(value = "brand")
    private String brand;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "description")
    private String description;

    @TableField(value = "stock_quantity")
    private Integer stock_quantity;

    @TableField(value = "image_url")
    private String image_url;

    @TableField(value = "manufacturing_date")
    private Date manufacturing_date;

    @TableField(value = "expiry_date")
    private Date expiry_date;

    @TableField(value = "weight")
    private BigDecimal weight;

    @TableField(value = "`length`")
    private BigDecimal length;

    @TableField(value = "width")
    private BigDecimal width;

    @TableField(value = "height")
    private BigDecimal height;

    @TableField(value = "is_discontinued")
    private Boolean is_discontinued;
}