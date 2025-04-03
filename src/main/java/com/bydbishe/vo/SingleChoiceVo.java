package com.bydbishe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleChoiceVo implements Serializable {
    private String title;
    private String OPA;
    private String OPB;
    private String OPC;
    private String OPD;
    private String diff;
    private String picture;
    private Integer uid;
}
