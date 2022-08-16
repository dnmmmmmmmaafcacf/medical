package com.medical.mapper;

import com.medical.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.Doctor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    //查询科室名名称和医院id外键
    @Select("SELECT * FROM department WHERE d_name = #{dName} and hid = #{hid}")
    Department selHidAndName(String dName,int hid);
}
