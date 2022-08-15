package com.medical.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.common.Result;
import com.medical.service.impl.UserServiceImpl;
import org.springframework.web.util.HtmlUtils;

import javax.jws.soap.SOAPBinding;
import javax.management.Query;
import java.util.List;
=======


import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
    @Autowired
    UserMapper userMapper;
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        name = HtmlUtils.htmlEscape(name);  //可将HTML标签互相转义
        user.setName(name);
        user.setPassword(password);
        boolean ex = userService.isExist(name);
        if (ex){
        Result result= new Result("0","用户名已被注册");
        return result;
        }else {
            //调用业务层方法，插入到DB，统一处理异常
            userService.save(user);
            Result result = new Result("1", "注册成功");
            return result;
        }
    }
    /**
     *
     */
=======

    UserMapper userMapper;

    @Autowired
    UserService userService;

    @PostMapping("/userUpdate")
    public Map<String,Object> userUpdate(@RequestBody User user) {
        int i = userMapper.userUpdate(user);
        HashMap<String,Object> map= new HashMap<>();
        if (i!=0){
            map.put("code",200);
            map.put("mag","修改成功");
            map.put("data",i);
            return map;
        }else {
            map.put("code",500);
            map.put("mag","修改失败");
            map.put("data",i);

            return map;
        }




    }

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
