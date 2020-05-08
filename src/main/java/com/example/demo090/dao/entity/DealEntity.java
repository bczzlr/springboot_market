package com.example.demo090.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.internal.constraintvalidators.bv.money.NegativeValidatorForMonetaryAmount;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 交易实体类
 */
@Entity
@Table(name = "Deal")
public class DealEntity {

    //交易id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private Long dealID;

    //交易地点
    @Column(name = "deal_location")
    private String dealLocation;

    //交易时间
    @Column(name = "deal_changetime")
    private LocalDateTime dealChangeTime;

    //和商品表建立一对一联系
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_com_id")
    private CommodityEntity commodityEntity;

    //和用户表建立多对一联系
    @JsonManagedReference
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "out_user_id",referencedColumnName = "id")
    private UserEntity userEntity;

    public Long getDealID() {
        return dealID;
    }

    public void setDealID(Long dealID) {
        this.dealID = dealID;
    }

    public String getDealLocation() {
        return dealLocation;
    }

    public void setDealLocation(String dealLocation) {
        this.dealLocation = dealLocation;
    }

    public LocalDateTime getDealChangeTime() {
        return dealChangeTime;
    }

    public void setDealChangeTime(LocalDateTime dealChangeTime) {
        this.dealChangeTime = dealChangeTime;
    }

//    public CommodityEntity getCommodityEntity() {
//        return commodityEntity;
//    }
//
//    public void setCommodityEntity(CommodityEntity commodityEntity) {
//        this.commodityEntity = commodityEntity;
//    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

//    @Override
//    public String toString() {
//        return "DealEntity{" +
//                "dealID=" + dealID +
//                ", dealLocation='" + dealLocation + '\'' +
//                ", dealChangeTime=" + dealChangeTime +
//                ", commodityEntity=" + commodityEntity +
//                ", userEntity=" + userEntity +
//                '}';
//    }
}
