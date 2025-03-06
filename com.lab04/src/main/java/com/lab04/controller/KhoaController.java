package com.Lab04.controller;

import com.Lab04.dto.KhoaDTO;
import com.Lab04.entity.Khoa;
import com.Lab04.service.KhoaService;
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
public class KhoaController {
    @Autowired
    KhoaService khoaService;

//    Lấy danh sách khoa
    @GetMapping("/khoa-list")
    public List<Khoa> getAllKhoas() {
        return khoaService.findAll();
    }

//    Lấy thông tin khoa theo makh
    @GetMapping("/khoa/{makh}")
    public Khoa getAllKhoas(@PathVariable String makh) {
        return khoaService.getKhoa(makh);
    }

//    Thêm mới 1 khoa
    @PostMapping("/khoa-add")
    public ResponseEntity<String> addKhoa(@Valid @RequestBody KhoaDTO khoa) {
        khoaService.create(khoa);
        return ResponseEntity.badRequest().body("Khoa created successfully");
    }

//    Sửa thông tin khoa
    @PutMapping("/khoa/{makh}")
    public Khoa updateKhoa(@PathVariable String makh, @RequestBody Khoa khoa) {
        return  khoaService.updateKhoa(makh, khoa);
    }

//    Xóa thông tin khoa theo makh
    @DeleteMapping("/khoa/{makh}")
    public boolean deleteKhoa(@PathVariable String makh) {
        return khoaService.deleteKhoa(makh);
    }
}
