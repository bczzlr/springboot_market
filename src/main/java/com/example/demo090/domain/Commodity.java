package com.example.demo090.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {


    private Long comID;

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
