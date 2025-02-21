package com.sky.service.impl;

import com.sky.constant.StatusConstant;
import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
