package com.medical.controller;


import com.medical.entity.Orderitme;
import com.medical.entity.User;
import com.medical.service.OrderitmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单项 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/orderitme")
public class OrderitmeController {
    @Autowired
    OrderitmeService orderitmeService;

    @GetMapping("/Order")
    public Map<String,Object> selectOrderByUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Orderitme> orderitmes = orderitmeService.selectByUid(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",orderitmes);
        return map;
    }
}
