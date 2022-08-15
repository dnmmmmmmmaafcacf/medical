package com.medical.mapper;

import com.medical.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ReviewMapper extends BaseMapper<Review> {
    List<Review> selectMunityReviewByUser(int uid);

    List<Review> selectDrugReviewByUser(int uid);
}
