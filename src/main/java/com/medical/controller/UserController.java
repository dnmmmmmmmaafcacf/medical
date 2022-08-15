package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.common.Result;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import com.medical.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.jws.soap.SOAPBinding;
import javax.management.Query;
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
}
