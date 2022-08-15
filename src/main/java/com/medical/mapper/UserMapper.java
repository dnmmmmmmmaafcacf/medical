package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */


@Mapper
public interface UserMapper extends BaseMapper<User> {

//    public User getByName(String name);
     @Select("select name from user where name=#{name}")
     User selectUser(String name);

    int userUpdate(User user);

    @Select("select * from user where tel=#{tel}")
    User selectTel(int tel);

    User loginUser(String username,String password);

}
