package com.cqteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqteam.entity.Patient;
import java.util.List;

public interface PatientService extends IService<Patient> {

    boolean savePatient(Patient patient);
    boolean updatePatient(Patient patient);
    boolean deletePatient(Long id);
}
