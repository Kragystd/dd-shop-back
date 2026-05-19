package com.kragy.vo.goodsVo;

import com.kragy.entity_by_mybatis_generator.TbSpecificationOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbSpecificationVo {
    private Long id;
    private String specName;
    private List<TbSpecificationOption> options;

}