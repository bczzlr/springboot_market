package com.example.demo090.service;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.DealReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.DealEntity;

/**
 * 订单服务类
 */
public interface DealService {

    //根据用户商品订单信息创建订单
    public DealEntity makeDealService(Long userID, Long comID, DealReq dealReq);
}
