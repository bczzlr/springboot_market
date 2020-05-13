package com.example.demo090.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 评论信息包装类
 */
@Data
public class EvalInformation {
    private String e_comment;
    private Integer e_starts;
    private String c_name;
    private Double c_price;
    private String d_location;
    private LocalDateTime d_time;
    private String u_name;
}
