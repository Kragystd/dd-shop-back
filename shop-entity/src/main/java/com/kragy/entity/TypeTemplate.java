package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeTemplate implements Serializable {
    private Long id;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 关联规格
     */
    private String specIds;
    /**
     * 关联品牌
     */
    private String brandIds;
    /**
     * 自定义属性
     */
    private String customAttributeItems;


}

