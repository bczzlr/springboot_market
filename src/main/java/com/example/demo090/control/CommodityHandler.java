package com.example.demo090.control;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.domain.Commodity;
import com.example.demo090.domain.User;
import com.example.demo090.service.CommodityService;
import com.example.demo090.utils.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 商品controller
 */
@RestController
@RequestMapping("/commodity")
public class CommodityHandler {

    @Autowired
    CommodityService commodityService;

    @GetMapping("/findallcommodity")
    public List<Commodity> findAll(){
        return commodityService.getAll();
    }


    /**
     * 添加商品方法
     * @param commodityReq 商品
     * @param userReq 相应进行添加操作用户
     * @return
     */
    @PostMapping("/addcommodity")
    public Commodity addCommodity(@RequestBody Map<String, String> models) throws Exception {

        System.out.println(models);

        CommodityReq commodityReq = JsonXMLUtils.json2obj( models.get("com"), CommodityReq.class);
//        UserReq userReq = JsonXMLUtils.map2obj((Map<String, Object>) models.get("user"), UserReq.class);
        UserReq userReq = JsonXMLUtils.json2obj(models.get("user"), UserReq.class);


        Commodity commodity = commodityService.addCommodityFromOneUser(commodityReq, userReq);

        return commodity;
    }

}
