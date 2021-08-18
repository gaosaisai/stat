package com.example.stat.vo;

import lombok.Data;

import java.util.List;

@Data
public class PieVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
