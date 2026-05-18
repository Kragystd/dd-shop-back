package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCategory implements Serializable {
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;


}

