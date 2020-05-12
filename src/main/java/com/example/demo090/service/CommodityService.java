package com.example.demo090.service;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.domain.Commodity;

import java.util.List;

public interface CommodityService {

    public Commodity createOne(CommodityReq commodityReq);

    public List<Commodity> getAll();

    public  List<CommodityEntity> getStatus();

    public Commodity addCommodityFromOneUser(CommodityReq commodityReq, UserReq userReq);

}
