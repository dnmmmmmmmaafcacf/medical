package com.medical.controller;


import cn.hutool.core.lang.hash.Hash;
import com.medical.entity.Review;
import com.medical.result.R;
import com.medical.service.DrugService;
import com.medical.service.MunityService;
import com.medical.service.ReviewService;
import com.medical.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @DeleteMapping("/delRev")
    public Object delReview(int id){
        reviewService.removeById(id);
        return R.ok("删除成功");
    }

}
