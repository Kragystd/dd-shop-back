package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDesc implements Serializable {
    /**
     * SPU_ID
     */
    private Long goodsId;
    /**
     * 描述
     */
    private String introduction;
    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;
    /**
     * 自定义属性（参数结果）
     */
    private String customAttributeItems;
    private String itemImages;
    /**
     * 包装列表
     */
    private String packageList;
    /**
     * 售后服务
     */
    private String saleService;


}

