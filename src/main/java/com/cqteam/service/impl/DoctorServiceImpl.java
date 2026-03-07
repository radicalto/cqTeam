package com.cqteam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqteam.entity.Doctor;
import com.cqteam.mapper.DoctorMapper;
import com.cqteam.service.DoctorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {



    @Override
    public boolean saveDoctor(Doctor doctor) {
        return this.save(doctor);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return this.updateById(doctor);
    }

    @Override
    public boolean deleteDoctor(Long id) {
        return this.removeById(id);
    }

    @Override
    public List<Doctor> getByDepartment(String department) {
        LambdaQueryWrapper<Doctor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Doctor::getDepartment, department);
        return this.list(wrapper);
    }
}
