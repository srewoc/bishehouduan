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
public class Admin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer type;
}
