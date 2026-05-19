package com.kragy.mapper;

import com.kragy.entity.TypeTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeTemplateMapper {

    TypeTemplate selectByPrimaryKey(Long id);

    List<TypeTemplate> selectConditionally(TypeTemplate typeTemplate);

    int insertSelective(TypeTemplate typeTemplate);

    int updateByPrimaryKeySelective(TypeTemplate typeTemplate);

    int deleteByPrimaryKey(Long id);

}

