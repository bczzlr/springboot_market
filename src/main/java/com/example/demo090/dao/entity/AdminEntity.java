package com.example.demo090.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 管理员实体类类
 */
@Entity
@Data
@Table(name = "admin")
//不和任何表建立联系
public class AdminEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
}
