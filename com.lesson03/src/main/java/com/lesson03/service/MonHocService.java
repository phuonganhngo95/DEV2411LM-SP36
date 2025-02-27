package com.lesson03.service;

import com.lesson03.enity.MonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MonHocService {
    //    Mock data
    List<MonHoc> monHocs = new ArrayList<MonHoc>();

    public MonHocService() {
        monHocs.addAll(Arrays.asList(
                new MonHoc("TCS", "Tin cơ sở", 15),
                new MonHoc("LTHDT", "Lập trình hướng đối tượng", 20),
                new MonHoc("CTDLGT", "Cấu trúc dữ liệu giải thuật", 25)
        ));
    }
    //    Lấy toàn bộ danh sách
    public List<MonHoc> getMonHocs() {
        return monHocs;
    }

    //    Lấy danh sách theo mamh
    public MonHoc geMonHoc(String mamh) {
        return monHocs.stream().filter(monHoc -> monHoc.getMamh().equals(mamh)).findFirst().orElse(null);
    }

    //    Thêm mới 1 môn học
    public MonHoc addMonHoc(MonHoc monHoc) {
        monHocs.add(monHoc);
        return monHoc;
    }

    //    Sửa đổi thông tin môn học theo mã
    public MonHoc updateMonHoc(String mamh, MonHoc monHoc) {
        MonHoc check = geMonHoc(mamh);
        if (check == null) {
            return null;
        }
        monHocs.forEach(item-> {
            if (item.getMamh() == mamh) {
                item.setTenmh(monHoc.getTenmh());
            }
        });
        return monHoc;
    }

    //    Xóa thông tin môn học theo mã
    public boolean deleteMonHoc(String mamh) {
        MonHoc check = geMonHoc(mamh);
        return monHocs.remove(check);
    }
}
