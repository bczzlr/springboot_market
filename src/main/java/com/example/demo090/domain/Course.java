package com.example.demo090.domain;

import lombok.*;

/**
 * 尝试Lombok简化JavaBean
 */
//简化创建对象
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Course {



    private long id;

    //课程名称
    private String name;

    //分数
    private Integer score;
}
