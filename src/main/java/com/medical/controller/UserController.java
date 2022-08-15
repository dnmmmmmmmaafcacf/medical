package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    private UserService userService;

    @PostMapping("/login")
//    @ResponseBody
    public Map<String,Object> checkLogin(String username, String password, HttpSession session){

        User users=userService.checkLogin(username,password);
        session.setAttribute("user",users);
        session.getAttribute("user");
//        if(!users.isEmpty()){
//            return "登录失败";
//        }else{
//            return "登录成功";
//        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("叼你妈",users);
        return map;
    }

    @PostMapping("/userInsert")
    public boolean userIsert(@RequestBody User user) {
        boolean save = userService.save(user);
        return save;
    }

}
