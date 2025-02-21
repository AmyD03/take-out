package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 分类业务层
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    public void save(CategoryDTO categoryDTO){
        Category category = new Category();
        //属性拷贝
        BeanUtils.copyProperties(categoryDTO,category);

        //分类状态默认为禁用状态0
        category.setStatus(StatusConstant.DISABLE);

        categoryMapper.insert(category);
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    public List<Category> list(Integer type){
        return categoryMapper.list(type);
    }

}
