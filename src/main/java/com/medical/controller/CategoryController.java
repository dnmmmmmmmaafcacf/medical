package com.medical.controller;


import com.medical.entity.Category;
import com.medical.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 药品分类 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/category")
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @PostMapping("/insert")
    public Object insert(@RequestBody Category category){
        return  categoryMapper.insert(category);
    }

    @GetMapping("/selectbyid")
    public Object select(int id){
        Category category = categoryMapper.selectById(id);
        return category;
    }


}
