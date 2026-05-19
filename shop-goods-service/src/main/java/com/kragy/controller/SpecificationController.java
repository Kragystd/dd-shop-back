package com.kragy.controller;

import com.kragy.dto.PageDto;
import com.kragy.dto.TbSpecificationDto;
import com.kragy.entity.Specification;
import com.kragy.entity_by_mybatis_generator.TbSpecification;
import com.kragy.service.SpecificationService;
import com.kragy.vo.goodsVo.TbSpecificationVo;
import com.kragy.vo.pagelist.PageList;
import com.kragy.vo.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;
    @Operation(summary = "获取所有规格", description = "获取系统中所有的规格列表")
    @GetMapping("/getAllSpec")
    public Result<List<TbSpecificationVo>> getAllSpec() {
        List<TbSpecificationVo> tbSpecificationVos = specificationService.getAllSpec();
        return tbSpecificationVos != null ? Result.success(tbSpecificationVos) : Result.error("查询失败");
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取规格", description = "通过规格ID获取规格详细信息")
    public Result<TbSpecificationVo> getSpecificationById(@Parameter(description = "规格ID") @PathVariable Long id) {
        TbSpecificationVo tbSpecificationVo = specificationService.getSpecificationById(id);
        return tbSpecificationVo != null ? Result.success(tbSpecificationVo) : Result.error("查询失败");
    }

    @Operation(summary="分页获取规格列表",description = "根据分页参数获取规格列表")
    @PostMapping("page")
    public Result<PageList<TbSpecificationVo>> getSpecificationListByPage(@Parameter(description = "分页查询参数") @RequestBody PageDto<Specification> pageDto) {

        return Result.success(specificationService.getSpecificationListByPage(pageDto));
    }

    @Operation(summary="添加/修改规格",description = "添加或修改一个规格")
    @PostMapping("/save")
    public Result<Integer> saveSpecification(@Parameter(description = "规格信息对象") @RequestBody TbSpecificationDto tbSpecificationDto) {
        if(tbSpecificationDto.getId() == null) {
            return specificationService.addSpecification(tbSpecificationDto) > 0 ? Result.success(1) : Result.error("添加失败");
        } else {
            return specificationService.updateSpecification(tbSpecificationDto) > 0 ? Result.success(1) : Result.error("修改失败");
        }
    }
    @Operation(summary="删除规格",description = "通过规格ID删除一个规格")
    @DeleteMapping("/{id}")
    public Result<Integer> deleteSpecification(@Parameter(description = "规格ID") @PathVariable Long id) {
        return specificationService.deleteSpecification(id) > 0 ? Result.success(1) : Result.error("删除失败");
    }
    @Operation(summary="批量删除规格",description = "通过规格ID列表批量删除规格")
    @PatchMapping("/batchDelete")
    public Result<Integer> batchDeleteSpecification(@Parameter(description = "规格ID列表") @RequestBody List<Long> ids) {
        return specificationService.batchDeleteSpecification(ids) > 0 ? Result.success(1) : Result.error("批量删除失败");
    }


}
