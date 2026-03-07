package com.cqteam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqteam.entity.Registration;
import com.cqteam.mapper.RegistrationMapper;
import com.cqteam.service.RegistrationService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {




    @Override
    public boolean saveRegistration(Registration registration) {
        return this.save(registration);
    }

    @Override
    public boolean updateRegistration(Registration registration) {
        return this.updateById(registration);
    }

    @Override
    public boolean deleteRegistration(Long id) {
        return this.removeById(id);
    }

    @Override
    public List<Registration> getByPatientId(Long patientId) {
        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getPatientId, patientId);
        return this.list(wrapper);
    }

    @Override
    public List<Registration> getByDate(LocalDate date) {
        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getVisitDate, date);
        return this.list(wrapper);
    }

    @Override
    public List<Registration> getByStatus(Integer status) {
        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getStatus, status);
        return this.list(wrapper);
    }
}
