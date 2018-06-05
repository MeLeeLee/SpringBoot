package com.melelee.springboot.bean;

import lombok.Data;

import java.util.Date;
@Data
public class Organization {
    private String id;

    private String name;

    private String code;

    private String higherOrg;

    private String higherName;

    private Integer level;

    private Integer status;

    private Integer sort;

    private String remark;

    private Date createTime;

    private Date updateTime;
}