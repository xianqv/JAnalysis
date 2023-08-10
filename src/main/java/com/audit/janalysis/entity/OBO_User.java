package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("OBO_user")
public class OBO_User {
    private int id;
    private String username;
    private String password;
    private String email;
}
