package com.cqteam.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqteam.common.Result;
import com.cqteam.entity.Prescription;
import com.cqteam.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public Result<List<Prescription>> findAll() {
        return Result.success(prescriptionService.list());
    }

    @GetMapping("/{id}")
    public Result<Prescription> findById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getById(id);
        if (prescription == null) {
            return Result.error("处方不存在");
        }
        return Result.success(prescription);
    }

    @PostMapping
    public Result<Prescription> save(@RequestBody Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return Result.success(prescription);
    }

    @PutMapping("/{id}")
    public Result<Prescription> update(@PathVariable Long id, @RequestBody Prescription prescription) {
        prescription.setId(id);
        prescriptionService.updatePrescription(prescription);
        return Result.success(prescription);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return Result.success(null);
    }

    @GetMapping("/patient/{patientId}")
    public Result<List<Prescription>> findByPatientId(@PathVariable Long patientId) {
        return Result.success(prescriptionService.getByPatientId(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public Result<List<Prescription>> findByDoctorId(@PathVariable Long doctorId) {
        return Result.success(prescriptionService.getByDoctorId(doctorId));
    }

    @GetMapping("/registration/{registrationId}")
    public Result<List<Prescription>> findByRegistrationId(@PathVariable Long registrationId) {
        return Result.success(prescriptionService.getByRegistrationId(registrationId));
    }

    @GetMapping("/page")
    public Result<Page<Prescription>> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Prescription> page = new Page<>(pageNum, pageSize);
        return Result.success(prescriptionService.page(page));
    }
}
