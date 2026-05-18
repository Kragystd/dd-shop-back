package com.kragy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationOption implements Serializable {
    /**
     * 规格项ID
     */
    private Long id;
    /**
     * 规格项名称
     */
    private String optionName;
    /**
     * 规格ID
     */
    private Long specId;
    /**
     * 排序值
     */
    private Integer orders;


}

