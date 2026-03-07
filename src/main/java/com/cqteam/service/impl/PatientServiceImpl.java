package com.cqteam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqteam.entity.Patient;
import com.cqteam.mapper.PatientMapper;
import com.cqteam.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {



    @Override
    public boolean savePatient(Patient patient) {
        return this.save(patient);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return this.updateById(patient);
    }

    @Override
    public boolean deletePatient(Long id) {
        return this.removeById(id);
    }
}
