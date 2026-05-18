package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specification implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String specName;


}

