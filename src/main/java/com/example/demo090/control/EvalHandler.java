package com.example.demo090.control;


import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import com.example.demo090.dao.entity.Evaluate;
import com.example.demo090.dao.repository.CommodityRepository;
import com.example.demo090.dao.repository.DealRepository;
import com.example.demo090.dao.repository.EvalRepository;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.domain.User;
import com.example.demo090.onlyoneproperties.OnlyComID;
import com.example.demo090.utils.JsonXMLUtils;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 评价控制类
 */
@RestController
@RequestMapping("/eval")
public class EvalHandler {

    @Autowired
    EvalRepository evalRepository;

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    DealRepository dealRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 根据传入的map参数来操作数据库，进行订单评价工作
     * @param models
     * @return
     */
    @PostMapping("/makeeval")
    public Evaluate makeEval( @RequestBody Map<String, String> models) throws Exception {

        //获取数据
        OnlyComID onlyComID = JsonXMLUtils.json2obj(models.get("com"), OnlyComID.class);
        User user = JsonXMLUtils.json2obj(models.get("user"), User.class);
        Evaluate eval = JsonXMLUtils.json2obj(models.get("eval"), Evaluate.class);
        DealEntity dealEntity = JsonXMLUtils.json2obj(models.get("deal"), DealEntity.class);
        //System.out.println(onlyComID.getComID()+"--"+user.getId()+"--"+eval.getEvalComment()+"--"+dealEntity.getDealID());

        //开始进行dao层操作
        //首先更改商品状态并保存
        CommodityEntity com = commodityRepository.findByComID(onlyComID.getComID());
        com.setComStatus("commented");
        commodityRepository.save(com);

        //创建订单obj
        eval.setDeal(dealRepository.findByDealID(dealEntity.getDealID()));
        eval.setUser_eval(userRepository.findById(user.getId()).get());
        DealEntity deal_trans = dealRepository.findByDealID(dealEntity.getDealID());
        deal_trans.setEvaluate(eval);
        DealEntity save = dealRepository.save(deal_trans);


        //保存评价
        //Evaluate finalEval = evalRepository.save(eval);


        return evalRepository.findById(save.getEvaluate().getEvalID()).get();
    }

}
