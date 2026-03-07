package com.cqteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqteam.entity.Doctor;
import java.util.List;

public interface DoctorService extends IService<Doctor> {

    boolean saveDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(Long id);
    List<Doctor> getByDepartment(String department);
}
