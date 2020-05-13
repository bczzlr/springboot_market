package com.example.demo090.control;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import com.example.demo090.dao.entity.Evaluate;
import com.example.demo090.dao.entity.UserEntity;
import com.example.demo090.dao.repository.CommodityRepository;
import com.example.demo090.dao.repository.DealRepository;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.domain.DealWithCommodity;
import com.example.demo090.domain.EvalInformation;
import com.example.demo090.domain.User;
import com.example.demo090.service.EvalService;
import com.example.demo090.service.Result;
import com.example.demo090.service.ResultUtil;
import com.example.demo090.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserHandler {

    private static final int USERALREADYEXIST = -1;

    @Autowired
    EvalService evalService;

    @Autowired
    UserService userService;

    @Autowired
    DealRepository dealRepository;

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User findUserByData(@RequestBody UserReq userReq){
        User user = null;
        user = userService.findUserByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        return user;
    }

    /**
     * 用户注册contrllor,
     * @param userReq
     * @return
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody UserReq userReq){
        //System.out.println(userReq.getUsername());

        //如果用户名已经存在，提示用户名已经存在
        if (userService.isUserAlreadyReg(userReq)){
            User error_user = new User();
            error_user.setId(USERALREADYEXIST);
            error_user.setPassword("alreadyused");
            error_user.setUsername("alreadyused");
            return error_user;
        }
        //否则新建用户
        else {
            User user = userService.createOne(userReq);
            return user;
        }

    }

    /**
     * 测试下根据用户信息能查到什么
     * @return
     */
    @GetMapping("/testgetcom")
    public Set<CommodityEntity> testCommodityByUser(){
        UserEntity userEntity = userRepository.findById((long) 1).get();

        return userEntity.getCommodityEntities();
    }


    /**
     * 别动这个方法，出大问题
     * 已解决
     * @return
     */
    @GetMapping("/listtest")
    public Set<DealEntity> getSet() {
        //return (Set<DealEntity>) dealRepository.findoutid((long) 9);
        return userRepository.findByUsername("haha").getDealEntities();
    }

    /**
     * 根据传入的用户信息查找商品，其实不用发送user，直接发送id即可减少资源消耗，待改进
     * 第二次修改：返回的商品状态为已发布和已购买，商品并未被评论
     * @param user 用户对象
     * @return
     */
    @PostMapping("/getcombyuser")
    public Set<CommodityEntity> getCommodityByUser(@RequestBody User user){

        //UserEntity userEntity = new UserEntity();
        //新增功能，根据商品状态返回set，状态为traded的才返回

        Set<CommodityEntity> tradedCommodity = new HashSet<>();

        //用户发布的所有的商品
        Set<CommodityEntity> allCommodities = userRepository.findById(user.getId()).get().getCommodityEntities();
        //循环遍历
        for (CommodityEntity commodity : allCommodities) {
            //如果满足已发布或者已购买
            if ("released".equals(commodity.getComStatus()) || "traded".equals(commodity.getComStatus())){
                //加进set中取
                tradedCommodity.add(commodity);
            }

        }


        return tradedCommodity;
    }

    /**
     * 根据用户找订单
     * @param user
     * @return
     */
    @PostMapping("/getdealbyuser")
    public Set<DealWithCommodity> getDealByUser(@RequestBody User user){
        Set<DealWithCommodity> iters = userService.reMold(userRepository.findById(user.getId()).get().getDealEntities());
        Set<DealWithCommodity> finalSet = new HashSet<>();

        for (DealWithCommodity dealWithCommodity : iters) {
            if ("traded".equals(dealWithCommodity.getC_status())){
                finalSet.add(dealWithCommodity);
            }
        }
        return finalSet;
    }

    @PostMapping("/getevalbyuser")
    public Set<EvalInformation> getEvalByUser(@RequestBody User user){
        Set<Evaluate> evaluates = userRepository.findById(user.getId()).get().getEvaluates();
        Set<EvalInformation> evalInformations = evalService.reMold(evaluates);

        return evalInformations;
    }

}
