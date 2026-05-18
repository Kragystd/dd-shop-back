package com.kragy.vo.goodsVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandVo {
    private Long id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 首字母
     */
    private String firstChar;
}
