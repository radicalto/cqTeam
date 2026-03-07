package com.cqteam.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqteam.common.Result;
import com.cqteam.entity.Doctor;
import com.cqteam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public Result<List<Doctor>> findAll() {
        return Result.success(doctorService.list());
    }

    @GetMapping("/{id}")
    public Result<Doctor> findById(@PathVariable Long id) {
        Doctor doctor = doctorService.getById(id);
        if (doctor == null) {
            return Result.error("医生不存在");
        }
        return Result.success(doctor);
    }

    @PostMapping
    public Result<Doctor> save(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return Result.success(doctor);
    }

    @PutMapping("/{id}")
    public Result<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        doctor.setId(id);
        doctorService.updateDoctor(doctor);
        return Result.success(doctor);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return Result.success(null);
    }

    @GetMapping("/department/{dept}")
    public Result<List<Doctor>> findByDepartment(@PathVariable String dept) {
        return Result.success(doctorService.getByDepartment(dept));
    }

    @GetMapping("/search")
    public Result<List<Doctor>> searchByName(@RequestParam String name) {
        LambdaQueryWrapper<Doctor> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Doctor::getName, name);
        return Result.success(doctorService.list(wrapper));
    }

    @GetMapping("/page")
    public Result<Page<Doctor>> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Doctor> page = new Page<>(pageNum, pageSize);
        return Result.success(doctorService.page(page));
    }
}
