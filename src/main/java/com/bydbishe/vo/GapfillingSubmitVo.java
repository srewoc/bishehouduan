package com.bydbishe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapfillingSubmitVo implements Serializable {
    private Boolean flag;
    private String ans;
}
