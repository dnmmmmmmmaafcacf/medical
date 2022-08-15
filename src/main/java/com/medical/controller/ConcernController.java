package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Concern;
import com.medical.entity.Munity;
import com.medical.mapper.ConcernMapper;
import com.medical.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 关注 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/concern")
public class ConcernController {

    @Autowired
    ConcernMapper concernMapper;

    @PostMapping("/add")
    public Map<String,Object> addMunitty(int uid,int mid){
        QueryWrapper<Concern> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Concern> eq = queryWrapper.eq("uid",uid).eq("mid",mid);
        Concern concern = new Concern();
        Concern concern1 = concernMapper.selectOne(eq);
        HashMap<String,Object> map = new HashMap<>();
        if (concern1!=null){
            map.put("msg","您已关注");
            return map;
        }else {
            concern.setUid(uid);
            concern.setMid(mid);
            int insert = concernMapper.insert(concern);
            map.put("code",200);
            return  map;
        }
    }


}
