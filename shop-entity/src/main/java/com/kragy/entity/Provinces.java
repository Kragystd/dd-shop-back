package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provinces implements Serializable {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 省份ID
     */
    private String provinceid;
    /**
     * 省份名称
     */
    private String province;


}

