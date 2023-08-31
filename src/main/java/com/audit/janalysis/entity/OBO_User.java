package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("OBO_user")
public class OBO_User {
    private Integer id;
    private String username;
    private String password;
    private String email;

}
