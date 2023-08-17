package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("obo_permission")
public class OBO_Permission {
    private Integer id;
    private String name;
}
