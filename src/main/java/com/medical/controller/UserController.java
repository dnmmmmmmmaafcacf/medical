package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.extension.api.R;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String,Object> login(HttpSession session, String username,String password){
//        QueryWrapper<User> q = new QueryWrapper<>();
//        q.eq("username",user.getUsername());
//        q.eq("password",user.getPassword());
//        List list = userService.listObjs(q);
        User list = userService.loginUser(username,password);
        session.setAttribute("user",list);
        HashMap<String, Object> map = new HashMap<>();
        if (list.equals("")){
            map.put("code",500);
            map.put("msg","登录失败");
            map.put("data",list);
            return map;
        } else {
            map.put("code",200);
            map.put("msg","登录成功");
            map.put("data",list);
            return map;
        }

    }

}
