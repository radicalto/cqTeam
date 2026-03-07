package com.cqteam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqteam.entity.Prescription;
import com.cqteam.mapper.PrescriptionMapper;
import com.cqteam.service.PrescriptionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements PrescriptionService {



    @Override
    public boolean savePrescription(Prescription prescription) {
        return this.save(prescription);
    }

    @Override
    public boolean updatePrescription(Prescription prescription) {
        return this.updateById(prescription);
    }

    @Override
    public boolean deletePrescription(Long id) {
        return this.removeById(id);
    }

    @Override
    public List<Prescription> getByPatientId(Long patientId) {
        LambdaQueryWrapper<Prescription> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Prescription::getPatientId, patientId);
        return this.list(wrapper);
    }

    @Override
    public List<Prescription> getByDoctorId(Long doctorId) {
        LambdaQueryWrapper<Prescription> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Prescription::getDoctorId, doctorId);
        return this.list(wrapper);
    }

    @Override
    public List<Prescription> getByRegistrationId(Long registrationId) {
        LambdaQueryWrapper<Prescription> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Prescription::getRegistrationId, registrationId);
        return this.list(wrapper);
    }
}
