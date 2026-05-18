package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Areas implements Serializable {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 区域ID
     */
    private String areaid;
    /**
     * 区域名称
     */
    private String area;
    /**
     * 城市ID
     */
    private String cityid;


}

