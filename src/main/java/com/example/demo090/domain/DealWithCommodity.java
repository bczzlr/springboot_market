package com.example.demo090.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 新封装的信息集合类
 */
@Data
public class DealWithCommodity {

    //交易地点
    private String d_location;
    //时间
    private LocalDateTime d_time;
    //电话
    private String d_tele;
    //金额
    private Double c_prive;
    //商品名称
    private String c_name;
    //商品描述
    private String c_describe;
    //交易对象名称
    private String u_name;
}
