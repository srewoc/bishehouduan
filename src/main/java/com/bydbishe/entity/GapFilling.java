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
public class GapFilling implements Serializable {
    private Integer id;
    private Integer uid;
    private String picture;
    private String text;
    private String answer;
    private String difficulty;
    private String knowledge;
    private Integer kong;
    private Integer type;
    
}
