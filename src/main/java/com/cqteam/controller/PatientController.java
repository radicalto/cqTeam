package com.cqteam.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqteam.entity.Patient;
import com.cqteam.common.Result;
import com.cqteam.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public Result<List<Patient>> findAll() {
        return Result.success(patientService.list());
    }

    @GetMapping("/{id}")
    public Result<Patient> findById(@PathVariable Long id) {
        Patient patient = patientService.getById(id);
        if (patient == null) {
            return Result.error("患者不存在");
        }
        return Result.success(patient);
    }

    @PostMapping
    public Result<Patient> save(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return Result.success(patient);
    }

    @PutMapping("/{id}")
    public Result<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        patientService.updatePatient(patient);
        return Result.success(patient);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return Result.success(null);
    }

    @GetMapping("/search")
    public Result<List<Patient>> searchByName(@RequestParam String name) {
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Patient::getName, name);
        return Result.success(patientService.list(wrapper));
    }

    @GetMapping("/page")
    public Result<Page<Patient>> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Patient> page = new Page<>(pageNum, pageSize);
        return Result.success(patientService.page(page));
    }
}
