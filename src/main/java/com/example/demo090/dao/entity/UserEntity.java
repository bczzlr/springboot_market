package com.example.demo090.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户库表
 *
 * @author roylurui
 *
 */

@Entity

@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String telephonenum;

//    @OneToMany(targetEntity = CommodityEntity.class)
//    @JoinColumn(name = "out_user_id", referencedColumnName = "id")

    //商品set
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<CommodityEntity> commodityEntities = new HashSet<>();

    //未处理商品set
    @OneToMany(mappedBy = "user_un")
    @JsonBackReference
    private Set<UnHandledCommunityEntity> unHandledCommunities = new HashSet<>();

    //订单set
    //JsonBackReference从关系注解
    @OneToMany(mappedBy = "userEntity")
    @JsonBackReference
    private Set<DealEntity> dealEntities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephonenum() {
        return telephonenum;
    }

    public void setTelephonenum(String telephonenum) {
        this.telephonenum = telephonenum;
    }

    public Set<CommodityEntity> getCommodityEntities() {
        return commodityEntities;
    }

    public void setCommodityEntities(Set<CommodityEntity> commodityEntities) {
        this.commodityEntities = commodityEntities;
    }

    public Set<DealEntity> getDealEntities() {
        return dealEntities;
    }

    public void setDealEntities(Set<DealEntity> dealEntities) {
        this.dealEntities = dealEntities;
    }

//    @Override
//    public String toString() {
//        return "UserEntity{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", telephonenum='" + telephonenum + '\'' +
//                ", commodityEntities=" + commodityEntities +
//                ", dealEntities=" + dealEntities +
//                '}';
//    }
}
