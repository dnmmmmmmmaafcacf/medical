package com.medical.controller;


import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/orders")
public class OrdersController {
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrdersService ordersService;

}
