package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Consulting;
import com.medical.entity.User;
import com.medical.mapper.ConsultingMapper;
import com.medical.service.ConsultingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 咨询表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/consulting")
public class ConsultingController {
    @Autowired
    ConsultingMapper consultingMapper;

    @PostMapping("/addConsulting")
    public Map<String,Object> addConsulting( HttpSession session,int doid,String describe ){
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        Consulting consulting = new Consulting();
        consulting.setCreateDate(new Date());
        consulting.setCState(ConsultingService.await);
        consulting.setUId(uid);
        consulting.setDoid(doid);
        consulting.setDescribes(describe);
        int insert = consultingMapper.insert(consulting);
        HashMap<String, Object> map = new HashMap<>();
        if (insert==0){
            map.put("code",500);
            map.put("msg","提交失败");
            return map;
        }else {
            map.put("code",200);
            map.put("msg","提交成功");
            return map;
        }


    }
}
