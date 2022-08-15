package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE username=#{username} and  password= #{password}")
    User checkLogin(@Param("username") String username, @Param("password") String password);
}
