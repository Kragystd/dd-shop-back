package com.kragy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kragy.dto.PageDto;
import com.kragy.dto.TbSpecificationDto;
import com.kragy.entity.Specification;
import com.kragy.entity_by_mybatis_generator.TbSpecification;
import com.kragy.entity_by_mybatis_generator.TbSpecificationExample;
import com.kragy.entity_by_mybatis_generator.TbSpecificationOption;
import com.kragy.entity_by_mybatis_generator.TbSpecificationOptionExample;
import com.kragy.mapper.TbSpecificationMapper;
import com.kragy.mapper.TbSpecificationOptionMapper;
import com.kragy.service.SpecificationService;
import com.kragy.vo.goodsVo.TbSpecificationVo;
import com.kragy.vo.pagelist.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public PageList<TbSpecificationVo> getSpecificationListByPage(PageDto<Specification> pageDto) {
        Page<TbSpecification> page = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        TbSpecificationExample example = new TbSpecificationExample();

        if (pageDto.getParams() != null && pageDto.getParams().getSpecName() != null && !"".equals(pageDto.getParams().getSpecName())) {
            example.createCriteria().andSpecNameLike("%" + pageDto.getParams().getSpecName() + "%");
        }
        List<TbSpecification> list = tbSpecificationMapper.selectByExample(example);
        List<TbSpecificationVo> rows = list.stream().map(tbSpecification -> {
            TbSpecificationVo tbSpecificationVo = new TbSpecificationVo();
            BeanUtils.copyProperties(tbSpecification, tbSpecificationVo);
            return tbSpecificationVo;
        }).toList();
        return new PageList<>(page.getTotal(), rows);
    }

    @Override
    public Integer addSpecification(TbSpecificationDto tbSpecificationDto) {
        TbSpecification tbSpecification = new TbSpecification();
        BeanUtils.copyProperties(tbSpecificationDto, tbSpecification);
        int i = tbSpecificationMapper.insertSelective(tbSpecification);
        if (i > 0) {
            List<TbSpecificationOption> options = tbSpecificationDto.getOptions();
            for (TbSpecificationOption option : options) {
                option.setSpecId(tbSpecification.getId());
                tbSpecificationOptionMapper.insertSelective(option);
            }
        }
        return 1;
    }

    @Override
    public Integer updateSpecification(TbSpecificationDto tbSpecificationDto) {
        TbSpecification tbSpecification = new TbSpecification();
        BeanUtils.copyProperties(tbSpecificationDto, tbSpecification);
        int i = tbSpecificationMapper.updateByPrimaryKeySelective(tbSpecification);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        example.createCriteria().andSpecIdEqualTo(tbSpecification.getId());
        tbSpecificationOptionMapper.deleteByExample(example);
        if (i > 0) {
            List<TbSpecificationOption> options = tbSpecificationDto.getOptions();
            for (TbSpecificationOption option : options) {
                option.setSpecId(tbSpecification.getId());
                tbSpecificationOptionMapper.insertSelective(option);
            }
        }
        return 1;
    }

    @Override
    public TbSpecificationVo getSpecificationById(Long id) {
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        TbSpecificationVo tbSpecificationVo = new TbSpecificationVo();
        BeanUtils.copyProperties(tbSpecification, tbSpecificationVo);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        example.createCriteria().andSpecIdEqualTo(id);
        tbSpecificationVo.setOptions(tbSpecificationOptionMapper.selectByExample(example));
        return tbSpecificationVo;
    }

    @Override
    public int deleteSpecification(Long id) {
        int i = tbSpecificationMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            example.createCriteria().andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(example);
        }
        return i;
    }

    @Override
    public int batchDeleteSpecification(List<Long> ids) {
        int i = 0;
        for (Long id : ids) {
            i += tbSpecificationMapper.deleteByPrimaryKey(id);
            if (i > 0) {
                TbSpecificationOptionExample example = new TbSpecificationOptionExample();
                example.createCriteria().andSpecIdEqualTo(id);
                tbSpecificationOptionMapper.deleteByExample(example);
            }
        }
        return i;
    }

    @Override
    public List<TbSpecificationVo> getAllSpec() {
        List<TbSpecification> specifications = tbSpecificationMapper.selectByExample(new TbSpecificationExample());
        
        return specifications.stream().map(spec -> {
            TbSpecificationVo vo = new TbSpecificationVo();
            BeanUtils.copyProperties(spec, vo);
            
            TbSpecificationOptionExample optionExample = new TbSpecificationOptionExample();
            optionExample.createCriteria().andSpecIdEqualTo(spec.getId());
            List<TbSpecificationOption> options = tbSpecificationOptionMapper.selectByExample(optionExample);
            vo.setOptions(options);
            
            return vo;
        }).toList();
    }
}
