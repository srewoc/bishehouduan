package com.bydbishe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GapfillingVo implements Serializable {
    private String title;
    private String diff;
    private Integer gapcnt;
    private String picture;
    private Integer uid;
}
