package com.medical.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.medical.entity.Department;
import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.service.DepartmentService;
import com.medical.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 预约挂号 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/registered")
public class RegisteredController {
    @Autowired
    RegisteredService registeredService;
    @Autowired
    DepartmentService departmentService;

    //我的预约
    @RequestMapping("/selectReg")
    public Map<String,Object> getReg(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Registered> reg = registeredService.getReg(user.getId());
        HashMap<String, Object> map = new HashMap<>();
        if (reg.size()<1){
            map.put("msg","该账号没有预约");
//            map.put("data",reg);
            return map;
        }
        else {
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("data",reg);
            return map;
        }
    }

    //预约核酸检测
    @PostMapping("insNuclein")
    public Map<String,Object> insNuclein(HttpSession session,Registered registered,int hid){

        User user = (User) session.getAttribute("user");
        Department department = departmentService.selHidAndName("核酸检测", hid);

        registered.setDid(department.getId());
        registered.setAppointment(new Date());
        registered.setUid(user.getId());
        Random r = new Random();
        int i = r.nextInt(1000);
        Integer in = i;
        registered.setReservationNo(String.valueOf(in));
        boolean save = registeredService.save(registered);

        HashMap<String , Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","预约成功");
        map.put("data",save);
        return map;
    }

}
