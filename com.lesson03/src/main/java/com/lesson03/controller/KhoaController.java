package com.lesson03.controller;

import com.lesson03.enity.Khoa;
import com.lesson03.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    //    Lấy danh sách khoa
    @GetMapping("/khoa-list")
    public List<Khoa> getAllKhoas() {
        return khoaService.getKhoas();
    }

    //    Lấy thông tin khoa theo mã
    @GetMapping("/khoa/{makh}")
    public Khoa getAllKhoas(@PathVariable String makh) {
        return khoaService.getKhoa(makh);
    }

    //    Thêm mới 1 khoa
    @PostMapping("/khoa-add")
    public Khoa addKhoa(@RequestBody Khoa khoa) {
        return khoaService.addKhoa(khoa);
    }

    //    Sửa thông tin khoa
    @PutMapping("/khoa/{makh}")
    public Khoa updateKhoa(@PathVariable String makh, @RequestBody Khoa khoa) {
        return khoaService.updateKhoa(makh, khoa);
    }

    //    Xóa 1 khoa
    @DeleteMapping("/khoa/{makh}")
    public boolean deleteKhoa(@PathVariable String makh) {
        return khoaService.deleteKhoa(makh);
    }

}
