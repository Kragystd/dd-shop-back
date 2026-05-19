package com.kragy.service;

import com.kragy.dto.PageDto;
import com.kragy.dto.TbSpecificationDto;
import com.kragy.entity.Specification;
import com.kragy.entity_by_mybatis_generator.TbSpecification;
import com.kragy.entity_by_mybatis_generator.TbSpecificationOption;
import com.kragy.vo.goodsVo.TbSpecificationVo;
import com.kragy.vo.pagelist.PageList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecificationService {
    PageList<TbSpecificationVo> getSpecificationListByPage(PageDto<Specification> pageDto);

    Integer addSpecification(TbSpecificationDto tbSpecificationDto);

    Integer updateSpecification(TbSpecificationDto tbSpecificationDto);

    TbSpecificationVo getSpecificationById(Long id);

    int deleteSpecification(Long id);

    int batchDeleteSpecification(List<Long> ids);

    List<TbSpecificationVo> getAllSpec();
}

