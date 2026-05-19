package com.kragy.controller;

import com.kragy.dto.PageDto;
import com.kragy.entity.TypeTemplate;
import com.kragy.service.TypeTemplateService;
import com.kragy.vo.pagelist.PageList;
import com.kragy.vo.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "类型模板管理", description = "类型模板相关操作接口")
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Autowired
    private TypeTemplateService typeTemplateService;

    @Operation(summary = "分页获取类型模板列表", description = "根据分页参数获取类型模板列表")
    @PostMapping("/page")
    public Result<PageList<TypeTemplate>> queryByPage(@Parameter(description = "分页查询参数") @RequestBody PageDto<TypeTemplate> pageDto) {
        return Result.success(typeTemplateService.queryByPage(pageDto));
    }

    @Operation(summary = "根据ID获取类型模板", description = "通过类型模板ID获取详细信息")
    @GetMapping("/{id}")
    public Result<TypeTemplate> queryById(@Parameter(description = "类型模板ID") @PathVariable Long id) {
        TypeTemplate typeTemplate = typeTemplateService.queryById(id);
        return typeTemplate != null ? Result.success(typeTemplate) : Result.error("查询失败");
    }
    @Operation(summary="添加/修改类型模板",description = "添加或修改一个类型模板")
    @PostMapping("/save")
    public Result<Integer> save(@Parameter(description = "类型模板信息对象") @RequestBody TypeTemplate typeTemplate) {
        if(typeTemplate.getId() == null) {
            return typeTemplateService.insert(typeTemplate) > 0 ? Result.success(1) : Result.error("添加失败");
        } else {
            return typeTemplateService.update(typeTemplate) > 0 ? Result.success(1) : Result.error("修改失败");
        }
    }

    @Operation(summary = "添加类型模板", description = "新增一个类型模板信息")
    @PostMapping
    public Result<Integer> add(@Parameter(description = "类型模板信息对象") @RequestBody TypeTemplate typeTemplate) {
        return typeTemplateService.insert(typeTemplate) > 0 ? Result.success(1) : Result.error("添加失败");
    }

    @Operation(summary = "更新类型模板", description = "更新已有的类型模板信息")
    @PutMapping
    public Result<Integer> update(@Parameter(description = "类型模板信息对象") @RequestBody TypeTemplate typeTemplate) {
        return typeTemplateService.update(typeTemplate) > 0 ? Result.success(1) : Result.error("修改失败");
    }

    @Operation(summary = "根据ID删除类型模板", description = "通过类型模板ID删除指定类型模板")
    @DeleteMapping("/{id}")
    public Result<Integer> deleteById(@Parameter(description = "类型模板ID") @PathVariable Long id) {
        return typeTemplateService.deleteById(id) > 0 ? Result.success(1) : Result.error("删除失败");
    }
    @Operation(summary = "批量删除类型模板", description = "批量删除指定类型模板")
    @PatchMapping("/batchDelete")
    public Result<Integer> batchDelete(@Parameter(description = "类型模板ID列表") @RequestBody List<Long> ids) {
        return typeTemplateService.batchDeleteSpecification(ids) > 0 ? Result.success(1) : Result.error("批量删除失败");
    }
}

