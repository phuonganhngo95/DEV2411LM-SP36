package com.lesson03.controller;

import com.lesson03.enity.MonHoc;
import com.lesson03.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    //    Lấy danh sách môn học
    @GetMapping("/monhoc-list")
    public List<MonHoc> getAllMonHocs() {
        return monHocService.getMonHocs();
    }

    //    Lấy thông tin môn học theo id
    @GetMapping("/monhoc/{mamh}")
    public MonHoc getAllMonHoc(@PathVariable String mamh) {
        return monHocService.geMonHoc(mamh);
    }

    //    Thêm mới 1 môn học
    @PostMapping("/monhoc-add")
    public MonHoc addMonHoc(@RequestBody MonHoc monHoc) {
        return monHocService.addMonHoc(monHoc);
    }

    //    Sửa thông tin môn học
    @PutMapping("/monhoc/{mamh}")
    public MonHoc updateMonHoc(@PathVariable String mamh, @RequestBody MonHoc monHoc) {
        return monHocService.updateMonHoc(mamh, monHoc);
    }

    //    Xóa 1 sinh viên
    @DeleteMapping("/monhoc/{mamh}")
    public boolean deleteMonHoc(@PathVariable String mamh) {
        return monHocService.deleteMonHoc(mamh);
    }

}
