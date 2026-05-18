package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * SPU_ID
     */
    private Long goodsId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品单价
     */
    private Double price;
    /**
     * 商品购买数量
     */
    private Integer num;
    /**
     * 商品总金额
     */
    private Double totalFee;
    /**
     * 商品图片地址
     */
    private String picPath;
    private String sellerId;


}

