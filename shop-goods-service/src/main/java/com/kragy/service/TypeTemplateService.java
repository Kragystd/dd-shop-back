package com.kragy.service;

import com.kragy.dto.PageDto;
import com.kragy.entity.TypeTemplate;
import com.kragy.vo.pagelist.PageList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeTemplateService {

    TypeTemplate queryById(Long id);

    PageList<TypeTemplate> queryByPage(PageDto<TypeTemplate> pageDto);

    int insert(TypeTemplate typeTemplate);

    int update(TypeTemplate typeTemplate);

    int deleteById(Long id);

    int batchDeleteSpecification(List<Long> ids);
}
