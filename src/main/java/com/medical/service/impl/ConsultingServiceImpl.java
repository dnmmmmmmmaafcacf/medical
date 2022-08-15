package com.medical.service.impl;

import com.medical.entity.Consulting;
import com.medical.mapper.ConsultingMapper;
import com.medical.service.ConsultingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 咨询表 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class ConsultingServiceImpl extends ServiceImpl<ConsultingMapper, Consulting> implements ConsultingService {

    @Autowired
    ConsultingMapper consultingMapper;
}
