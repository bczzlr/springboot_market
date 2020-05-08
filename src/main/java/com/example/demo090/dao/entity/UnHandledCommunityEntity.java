package com.example.demo090.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 未处理商品实体类，先由管理员审核后添加至commodity表
 *
 * 此类设计失误，作废
 */
@Entity
@Data
@Table(name = "unhandledcom")
public class UnHandledCommunityEntity {
    //商品id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private Long comID;

    //商品价格
    @Column(name = "com_price")
    private Double comPrice;

    //商品名字
    @Column(name = "com_name")
    private String comName;

    //商品描述
    @Column(name = "com_describe")
    private String comDescribe;

    //发布时间
    @Column(name = "com_releasetime")
    private LocalDateTime comReleaseTime;

    //商品状态
    //release已经发布
    //traded 已经交易
    //commented 已经评论
    @Column(name = "com_status")
    private String comStatus;

    //和用户创建多对一关系
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "out_user_id",referencedColumnName = "id")
    @JsonManagedReference
    private UserEntity user_un;
}
