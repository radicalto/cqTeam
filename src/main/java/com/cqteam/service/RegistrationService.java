package com.cqteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqteam.entity.Registration;
import java.time.LocalDate;
import java.util.List;

public interface RegistrationService extends IService<Registration> {

    boolean saveRegistration(Registration registration);
    boolean updateRegistration(Registration registration);
    boolean deleteRegistration(Long id);
    List<Registration> getByPatientId(Long patientId);
    List<Registration> getByDate(LocalDate date);
    List<Registration> getByStatus(Integer status);
}
