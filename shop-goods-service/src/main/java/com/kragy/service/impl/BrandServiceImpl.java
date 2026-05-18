package com.kragy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kragy.dto.PageDto;
import com.kragy.entity.Brand;
import com.kragy.mapper.BrandMapper;
import com.kragy.service.BrandService;
import com.kragy.vo.goodsVo.BrandVo;
import com.kragy.vo.pagelist.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.selectAllBrand();
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.selectBrandById(id);
    }

    @Override
    public Brand getBrandByName(String name) {
        return brandMapper.selectBrandByName(name);
    }

    @Override
    public List<Brand> getBrandsByFirstChar(String firstChar) {
        return brandMapper.selectBrandsByFirstChar(firstChar);
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.insertBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandMapper.deleteBrandById(id);
    }

    @Override
    public int deleteBrandByIdBatch(List<Integer> ids) {
        return brandMapper.deleteBrandByIdBatch(ids);
    }

    @Override
    public PageList<BrandVo> getBrandListByPage(PageDto<Brand> pageDto) {
        Page<Brand> page = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        List<Brand> brands = brandMapper.selectConditionally(pageDto.getParams());
        List<BrandVo> rows = brands.stream().map(brand -> {
            BrandVo brandVo = new BrandVo();
            BeanUtils.copyProperties(brand, brandVo);
            return brandVo;
        }).toList();
        return new PageList<>(page.getTotal(), rows);
    }
}
