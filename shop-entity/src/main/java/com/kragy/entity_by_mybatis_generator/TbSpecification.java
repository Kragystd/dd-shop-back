package com.kragy.entity_by_mybatis_generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbSpecification {
    private Long id;
    private String specName;

}