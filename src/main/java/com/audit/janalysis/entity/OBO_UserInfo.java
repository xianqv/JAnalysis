package com.audit.janalysis.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("DBO_UserInfo")
public class OBO_UserInfo {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phone;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private String city;

    /**
     *
     */
    private String country;

    /**
     *
     */
    private String postalCode;

    /**
     *
     */
    private Date dateOfBirth;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private Date registrationDate;

    /**
     *
     */
    private Date lastLoginDate;

    /**
     *
     */
    private Integer totalOrders;

    /**
     *
     */
    private Integer loyaltyPoints;

    @Version
    private  Integer version;


}

