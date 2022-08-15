package com.medical.service.impl;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userInfoMapper;


    @Autowired
    UserMapper userMapper;

    @Override
    public User loginUser(String username, String password) {
        return userMapper.loginUser(username,password);

    @Autowired
    UserMapper userMapper;

    @Override
    public int userUpdate(User user) {
        return userMapper.userUpdate(user);
    }

//    @Override
//    public User selectTel(int tel) {
//        return null;
//    }


//    @Override
//    public User selectTel(int tel) {
//        return userMapper.selectTel(tel);
//    }

}
