package com.medical.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Concern;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    @Autowired
    UserMapper userMapper;

    @PostMapping("/addConcern")
    public Map<String,Object> addConcern(HttpSession session, int uiid){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getId();
        QueryWrapper<Concern> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Concern> eq = queryWrapper.eq("uid", uid).eq("uiid", uiid);
        Concern concern1 = new Concern();
        Concern concern = concernMapper.selectOne(eq);
        HashMap<String, Object> map = new HashMap<>();
        if (concern!=null){
            map.put("msg","你已关注过了亲");
            return map;
        }else{
            concern1.setUid(uid);
            concern1.setUiid(uiid);
            concernMapper.insert(concern1);
            map.put("code",200);
            return map;
        }
    }

    @GetMapping("/selectConcern")
    public Map<String,Object>selectConcern(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        QueryWrapper<Concern> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Concern> uid = queryWrapper.eq("uid", id);
        List<Concern> concerns = concernMapper.selectList(uid);
        int uiid;
        List<Integer> uiidlist = new ArrayList<>();
        List<User> users = null;
        for (Concern concern:concerns){
            uiid = concern.getUiid();
            uiidlist.add(uiid);
        }
        users = userMapper.selectBatchIds(uiidlist);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("Users",users);
        return map;
    }


}
