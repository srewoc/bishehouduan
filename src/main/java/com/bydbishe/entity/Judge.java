package com.bydbishe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Judge implements Serializable {
    private Integer id;
    private String text;
    private Integer answer;
    private String knowledge;
    private String difficulty;
    private String picture;
    private Integer uid;
    private Integer type;
    
}
