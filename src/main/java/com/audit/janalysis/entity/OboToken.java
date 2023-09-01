package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "JAnalysis.obo_token")
public class OboToken {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "token_value")
    private String token_value;

    @TableField(value = "user_id")
    private Long user_id;

    @TableField(value = "client_id")
    private String client_id;

    @TableField(value = "delegation_user_id")
    private String delegation_user_id;

    @TableField(value = "expires_in")
    private Integer expires_in;

    @TableField(value = "created_at")
    private Long created_at;

    @TableField(value = "updated_at")
    private Long updated_at;
}