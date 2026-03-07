package com.cqteam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqteam.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription> {
}
