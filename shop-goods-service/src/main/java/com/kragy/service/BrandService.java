package com.kragy.service;

import com.kragy.dto.PageDto;
import com.kragy.entity.Brand;
import com.kragy.vo.goodsVo.BrandVo;
import com.kragy.vo.pagelist.PageList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> getAllBrand();
    Brand getBrandById(Integer id);
    Brand getBrandByName(String name);
    List<Brand> getBrandsByFirstChar(String firstChar);
    int addBrand(Brand brand);
    int updateBrand(Brand brand);
    int deleteBrandById(Integer id);
    int deleteBrandByIdBatch(@Param("ids") List<Integer> ids);
    PageList<BrandVo> getBrandListByPage(PageDto<Brand> pageDto);
}
