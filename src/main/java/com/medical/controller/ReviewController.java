package com.medical.controller;


import com.medical.entity.Review;
import com.medical.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ReviewService reviewService;

    @RequestMapping("/selectMunityReviewByUser")
    public Map<String,Object> selectMunityReviewByUser(int uid){
        List<Review> reviews = reviewService.selectMunityReviewByUser(uid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",reviews);
        return map;
    }

    @RequestMapping("/selectDrugReviewByUser")
    public Map<String,Object> selectDrugReviewByUser(int uid){
        List<Review> reviews = reviewService.selectDrugReviewByUser(uid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",reviews);
        return map;
    }
}
