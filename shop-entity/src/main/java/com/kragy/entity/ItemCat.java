package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCat implements Serializable {
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类型id
     */
    private Long typeId;


}

