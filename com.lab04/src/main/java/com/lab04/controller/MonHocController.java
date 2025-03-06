package com.Lab04.controller;

import com.Lab04.dto.MonHocDTO;
import com.Lab04.entity.MonHoc;
import com.Lab04.service.MonHocService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class MonHocController {
    @Autowired
    MonHocService monHocService;

//    Lấy danh sách môn học
    @GetMapping("/monhoc-list")
    public List<MonHoc> getAllMonHocs() {
        return monHocService.findAll();
    }

//    Lấy thông tin môn học theo mamh
    @GetMapping("/monhoc/{mamh}")
    public MonHoc getAllMonHocs(@PathVariable String mamh) {
        return monHocService.getMonHoc(mamh);
    }

//    Thêm mới 1 môn học
    @PostMapping("/monhoc-add")
    public ResponseEntity<String> addMonHoc(@Valid @RequestBody MonHocDTO monHoc) {
        monHocService.create(monHoc);
        return ResponseEntity.badRequest().body("MonHoc created successfully");
    }

//    Sửa thông tin môn học
    @PutMapping("/monhoc/{mamh}")
    public MonHoc updateMonHoc(@PathVariable String mamh, @RequestBody MonHoc monHoc) {
        return monHocService.updateMonHoc(mamh, monHoc);
    }

//    Xóa thông tin môn học mamh
    @DeleteMapping("/monhoc/{mamh}")
    public boolean deleteMonHoc(@PathVariable String mamh) {
        return monHocService.deleteMonHoc(mamh);
    }
}
