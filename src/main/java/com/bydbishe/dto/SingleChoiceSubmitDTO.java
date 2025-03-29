package com.bydbishe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class SingleChoiceSubmitDTO implements Serializable {
    private String select;
    private Integer uid;
}
