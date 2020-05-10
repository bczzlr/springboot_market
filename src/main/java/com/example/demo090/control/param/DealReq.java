package com.example.demo090.control.param;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * 订单参数类，用于接收http请求
 */
@Data
public class DealReq {
    //交易地点
    private String dealLocation;

    //交易时间
    private LocalDateTime dealChangeTime;

    //交易人电话号码
    private String dealBuyerTelephone ;

}
