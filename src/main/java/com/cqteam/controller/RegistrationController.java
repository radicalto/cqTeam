package com.cqteam.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqteam.common.Result;
import com.cqteam.entity.Registration;
import com.cqteam.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public Result<List<Registration>> findAll() {
        return Result.success(registrationService.list());
    }

    @GetMapping("/{id}")
    public Result<Registration> findById(@PathVariable Long id) {
        Registration registration = registrationService.getById(id);
        if (registration == null) {
            return Result.error("挂号记录不存在");
        }
        return Result.success(registration);
    }

    @PostMapping
    public Result<Registration> save(@RequestBody Registration registration) {
        registrationService.saveRegistration(registration);
        return Result.success(registration);
    }

    @PutMapping("/{id}")
    public Result<Registration> update(@PathVariable Long id, @RequestBody Registration registration) {
        registration.setId(id);
        registrationService.updateRegistration(registration);
        return Result.success(registration);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return Result.success(null);
    }

    @GetMapping("/patient/{patientId}")
    public Result<List<Registration>> findByPatientId(@PathVariable Long patientId) {
        return Result.success(registrationService.getByPatientId(patientId));
    }

    @GetMapping("/date")
    public Result<List<Registration>> findByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return Result.success(registrationService.getByDate(date));
    }

    @GetMapping("/status/{status}")
    public Result<List<Registration>> findByStatus(@PathVariable Integer status) {
        return Result.success(registrationService.getByStatus(status));
    }

    @GetMapping("/page")
    public Result<Page<Registration>> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Registration> page = new Page<>(pageNum, pageSize);
        return Result.success(registrationService.page(page));
    }
}
