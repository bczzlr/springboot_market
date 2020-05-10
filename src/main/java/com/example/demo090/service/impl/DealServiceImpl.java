package com.example.demo090.service.impl;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.DealReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import com.example.demo090.dao.repository.CommodityRepository;
import com.example.demo090.dao.repository.DealRepository;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.service.DealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DealService实现类
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    DealRepository dealRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommodityRepository commodityRepository;

    @Override
    public DealEntity makeDealService(Long userID, Long comID, DealReq dealReq) {


        //存一个订单并获取改订单数据
        DealEntity target = new DealEntity();
        //拷贝数据
        BeanUtils.copyProperties(dealReq,target);

        target = dealRepository.save(target);

        //根据id把购买用户存入订单实体
        target.setUserEntity(userRepository.findById(userID).get());
        //根据id把商品信息存入订单实体
        target.setCommodityEntity(commodityRepository.findByComID(comID));

        //改变商品状态为以交易
        CommodityEntity commodity = commodityRepository.findByComID(comID);
        commodity.setComStatus("traded");
        commodity.setDeal(target);

        //保存
        DealEntity save = dealRepository.save(target);


        return save;
    }
}
