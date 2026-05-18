package com.kragy.mapper;

import com.kragy.dto.PageDto;
import com.kragy.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAllBrand();
    Brand selectBrandById(Integer id);
    Brand selectBrandByName(String name);
    List<Brand> selectBrandsByFirstChar(String firstChar);
    int insertBrand(Brand brand);
    int updateBrand(Brand brand);
    int deleteBrandById(Integer id);
    int deleteBrandByIdBatch(@Param("ids") List<Integer> ids);


    List<Brand> selectConditionally(Brand brand);
}
