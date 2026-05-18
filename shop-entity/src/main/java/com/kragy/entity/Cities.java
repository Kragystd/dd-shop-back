package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cities implements Serializable {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 城市ID
     */
    private String cityid;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 省份ID
     */
    private String provinceid;


}

