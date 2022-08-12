package com.medical.controller;

import com.medical.entity.Vip;
import com.medical.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/medical/vip")
public class VipController {
    @Autowired
    VipService vipService;

    //我的会员
    @RequestMapping("/selVip")
    public Map<String, Object> selVip(){
        List<Vip> vips = vipService.list();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","查询成功");
        map.put("data",vips);
        return map;
    }

    //开通会员
    @RequestMapping("/insVip")
    public Map<String,Object> insVip(Vip vip) throws ParseException {
        vip.setRegisterDate(new Date());
        Calendar ca = Calendar.getInstance();//创建Calendar对象
        ca.add(Calendar.DATE,31);//增加31天
        String s = ca.getTime().toLocaleString();//将时间打印出来
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//创建simpleDateFormat对象，时间规范为"yyyy-MM-dd HH:mm:ss"
        vip.setExpireDate(sim.parse(s));//将时间格式解析为日期，添加到截止时间
        boolean res = vipService.save(vip);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","新增成功");
        map.put("data",res);
        return map;
    }

}
