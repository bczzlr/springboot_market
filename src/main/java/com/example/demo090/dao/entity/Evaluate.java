package com.example.demo090.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 订单评价类
 */
@Data
@Entity
@Table(name = "evaluate")
public class Evaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eval_id")
    private Long evalID;

    //评论
    @Column(name = "eval_comment")
    private String evalComment;
//
    //订单星级
    @Column(name = "eval_stars")
   private String evalStars;

    //和用户建立一对一关系
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "eval_out_user_id",referencedColumnName = "id")
    @JsonManagedReference
    private UserEntity user_eval;

    //和交易表建立一对一联系
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eval_out_deal_id")
    //@OneToOne(mappedBy = "commodityEntity")
    @JsonManagedReference
    //@JsonBackReference
    //@JsonIgnore
    private DealEntity deal;
//
//    //交易人电话号码
//    @Column(name = "deal_buyertelephone")
//    private String dealBuyerTelephone ;
//
//    //和商品表建立一对一联系
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "commodity_com_id")
//    //@JsonBackReference
//    @JsonManagedReference
////    @OneToOne(mappedBy = "deal")
//    private CommodityEntity commodityEntity;
//
//    //和用户表建立多对一联系
//    @JsonManagedReference
//    @ManyToOne(targetEntity = UserEntity.class)
//    @JoinColumn(name = "out_user_id",referencedColumnName = "id")
//    private UserEntity userEntity;
}
