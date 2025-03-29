package com.bydbishe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BigProblem implements Serializable {
    private Integer id;
    private String text;
    private String answer;
    private String knowledge;
    private String difficulty;
    private String picture;
    private Integer kong;
    private Integer uid;
    private Integer type;
    
}
