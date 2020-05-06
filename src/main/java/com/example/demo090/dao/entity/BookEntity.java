package com.example.demo090.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private Double price;
}
