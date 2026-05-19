package com.kragy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kragy.dto.PageDto;
import com.kragy.entity.TypeTemplate;
import com.kragy.mapper.TypeTemplateMapper;
import com.kragy.service.TypeTemplateService;
import com.kragy.vo.pagelist.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public TypeTemplate queryById(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TypeTemplate> queryByPage(PageDto<TypeTemplate> pageDto) {
        Page<TypeTemplate> page = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        List<TypeTemplate> list = typeTemplateMapper.selectConditionally(pageDto.getParams());
        return new PageList<>(page.getTotal(), list);
    }

    @Override
    public int insert(TypeTemplate typeTemplate) {
        return typeTemplateMapper.insertSelective(typeTemplate);
    }

    @Override
    public int update(TypeTemplate typeTemplate) {
        return typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
    }

    @Override
    public int deleteById(Long id) {
        return typeTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDeleteSpecification(List<Long> ids) {
        int i = 0;
        for (Long id : ids) {
            i += typeTemplateMapper.deleteByPrimaryKey(id);
        }
        return i;
    }
}
