package com.cqteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqteam.entity.Prescription;
import java.util.List;

public interface PrescriptionService extends IService<Prescription> {

    boolean savePrescription(Prescription prescription);
    boolean updatePrescription(Prescription prescription);
    boolean deletePrescription(Long id);
    List<Prescription> getByPatientId(Long patientId);
    List<Prescription> getByDoctorId(Long doctorId);
    List<Prescription> getByRegistrationId(Long registrationId);
}
