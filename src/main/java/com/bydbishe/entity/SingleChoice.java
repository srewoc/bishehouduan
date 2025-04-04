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
public class SingleChoice implements Serializable {
    private Integer id;
    private String text;
    private String difficulty;
    private String answer;
    private String knowledge;
    private String picture;
    private Integer uid;
    private Integer type;
}
