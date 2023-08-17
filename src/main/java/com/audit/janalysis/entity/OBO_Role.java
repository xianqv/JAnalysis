package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("OBO_Role")
public class OBO_Role {

    private Integer id;
    private String name;
    private String permissions;
}
