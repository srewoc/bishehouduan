package com.bydbishe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO implements Serializable {
    private Integer page;//页码
    private Integer pagesize;//每页记录数
    private String knowledge;//根据知识点查询
    private Integer type;//根据题型查询
}
