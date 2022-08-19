package com.medical.service;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 医生信息 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DoctorService extends IService<Doctor> {
    ///根据科室id查询医生
    List<Doctor> likeDoAndDH(int did);
    //查询在线医生
    List<Doctor> getDoctorAndUser(String uState);
}
