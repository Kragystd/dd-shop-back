package com.kragy.controller;

import com.kragy.dto.PageDto;
import com.kragy.entity.Brand;
import com.kragy.service.BrandService;
import com.kragy.vo.goodsVo.BrandVo;
import com.kragy.vo.pagelist.PageList;
import com.kragy.vo.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "品牌管理", description = "品牌相关操作接口")
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Operation(summary = "获取所有品牌", description = "获取系统中所有的品牌列表")
    @GetMapping("/getAllBrand")
    Result<List<Brand>> getAllBrand() {
        List<Brand> brands = brandService.getAllBrand();
        return brands != null ? Result.success(brands) : Result.error("查询失败");
    }

    @Operation(summary = "根据ID获取品牌", description = "通过品牌ID获取品牌详细信息")
    @GetMapping("/{id}")
    Result<Brand> getBrandById(@Parameter(description = "品牌ID") @PathVariable Integer id) {
        Brand brand = brandService.getBrandById(id);
        return brand != null ? Result.success(brand) : Result.error("查询失败");
    }

    @Operation(summary = "根据名称获取品牌", description = "通过品牌名称获取品牌详细信息")
    @GetMapping("/name/{name}")
    Result<Brand> getBrandByName(@Parameter(description = "品牌名称") @PathVariable String name) {
        Brand brand = brandService.getBrandByName(name);
        return brand != null ? Result.success(brand) : Result.error("查询失败");
    }

    @Operation(summary = "根据首字母获取品牌", description = "通过品牌名称首字母获取品牌列表")
    @GetMapping("firstchar/{firstChar}")
    Result<List<Brand>> getBrandsByFirstChar(@Parameter(description = "品牌名称首字母") @PathVariable String firstChar) {
        List<Brand> brands = brandService.getBrandsByFirstChar(firstChar);
        return brands != null ? Result.success(brands) : Result.error("查询失败");
    }

    @Operation(summary = "添加品牌", description = "新增一个品牌信息")
    @PostMapping
    Result<Integer> addBrand(@Parameter(description = "品牌信息对象") @RequestBody Brand brand) {
        return brandService.addBrand(brand) > 0 ? Result.success(1) : Result.error("添加失败");
    }

    @Operation(summary = "更新品牌", description = "更新已有的品牌信息")
    @PutMapping
    Result<Integer> updateBrand(@Parameter(description = "品牌信息对象") @RequestBody Brand brand) {
        return brandService.updateBrand(brand) > 0 ? Result.success(1) : Result.error("修改失败");
    }

    @Operation(summary = "根据ID删除品牌", description = "通过品牌ID删除指定品牌")
    @DeleteMapping("/{id}")
    Result<Integer> deleteBrandById(@Parameter(description = "品牌ID") @PathVariable Integer id) {
        return brandService.deleteBrandById(id) > 0 ? Result.success(1) : Result.error("删除失败");
    }

    @Operation(summary = "批量删除品牌", description = "通过品牌ID列表批量删除品牌")
    @DeleteMapping("/batch")
    Result<Integer> deleteBrandByIdBatch(@Parameter(description = "品牌ID列表") @RequestParam List<Integer> ids) {
        return brandService.deleteBrandByIdBatch(ids) > 0 ? Result.success(1) : Result.error("批量删除失败");
    }

    @Operation(summary = "分页获取品牌列表", description = "根据分页参数获取品牌列表")
    @PostMapping("/page")
    Result<PageList<BrandVo>> getBrandListByPage(@Parameter(description = "分页查询参数") @RequestBody PageDto<Brand> pageDto) {
        return Result.success(brandService.getBrandListByPage(pageDto));
    }
    
    @Operation(summary = "获取中文字符串首字母", description = "传入字符串，自动去除特殊符号后返回第一个有效字符的拼音首字母")
    @GetMapping("/firstchar")
    Result<String> getFirstChar(@Parameter(description = "中文字符串") @RequestParam("characters") String characters) {
        return Result.success(brandService.getFirstChar(characters));
    }

}
