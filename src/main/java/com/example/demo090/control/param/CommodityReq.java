package com.example.demo090.control.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommodityReq {

    //商品价格
    private Double comPrice;

    //商品名字
    private String comName;

    //商品描述
    private String comDescribe;

    //发布时间
    private LocalDateTime comReleaseTime;

    //商品状态
    //release已经发布
    //traded 已经交易
    //commented 已经评论
    private String comStatus;
}
