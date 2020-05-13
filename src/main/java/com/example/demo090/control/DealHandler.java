package com.example.demo090.control;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.DealReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import com.example.demo090.dao.entity.UserEntity;
import com.example.demo090.onlyoneproperties.OnlyComID;
import com.example.demo090.service.DealService;
import com.example.demo090.utils.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单处理控制类
 */
@RestController
@RequestMapping("/deal")
public class DealHandler {

    @Autowired
    DealService dealService;

    /**
     * 根据传入数据提交订单信息
     * @param models 包含商品用户和订单信息的map，浪费资源，待改（等过一阵），具体格式见前端
     */
    @PostMapping("/makedeal")
    public DealEntity makeDeal( @RequestBody Map<String, String> models) throws Exception {

        //System.out.println(comid);
        //System.out.println(models.get("com"));
        //从map中获取数据
        OnlyComID com = JsonXMLUtils.json2obj( models.get("com"), OnlyComID.class);
        //System.out.println(com.getComID());
        //models.get("com").substring()
        UserEntity userReq = JsonXMLUtils.json2obj(models.get("user"), UserEntity.class);
        //System.out.println(userReq.getId());
        //应该封一个DealReq，待封装
        DealReq deal = JsonXMLUtils.json2obj((models.get("deal")), DealReq.class);
        System.out.println(deal.getDealLocation()+deal.getDealBuyerTelephone()+deal.getDealChangeTime());
        //保存操作
        DealEntity dealEntity = dealService.makeDealService(userReq.getId(),com.getComID(), deal);

        return dealEntity;

    }

}
