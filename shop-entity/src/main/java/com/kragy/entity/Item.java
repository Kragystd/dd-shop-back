package com.kragy.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    /**
     * 商品id，同时也是商品编号
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品卖点
     */
    private String sellPoint;
    /**
     * 商品价格，单位为：元
     */
    private Double price;
    /**
     * 现存库存
     */
    private Integer stockCount;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 商品条形码
     */
    private String barcode;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 所属类目，叶子类目
     */
    private Long categoryid;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    private String itemSn;
    /**
     * 成本价
     */
    private Double costPirce;
    /**
     * 市场价
     */
    private Double marketPrice;
    /**
     * 是否默认
     */
    private String isDefault;
    /**
     * SPU的id
     */
    private Long goodsId;
    /**
     * 商家id
     */
    private String sellerId;
    /**
     * 缩略图
     */
    private String cartThumbnail;
    /**
     * 类目
     */
    private String category;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 规格
     */
    private String spec;
    /**
     * 商家
     */
    private String seller;


}

