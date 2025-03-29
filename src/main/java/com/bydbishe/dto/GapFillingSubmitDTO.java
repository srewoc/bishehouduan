package com.bydbishe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GapFillingSubmitDTO implements Serializable {
    private List<String> gaps;
    private Integer uid;
}
