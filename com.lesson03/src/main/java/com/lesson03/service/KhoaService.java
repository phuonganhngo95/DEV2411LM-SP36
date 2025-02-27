package com.lesson03.service;

import com.lesson03.enity.Khoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KhoaService {
//    Mock data
    List<Khoa> khoas = new ArrayList<Khoa>();

    public KhoaService() {
        khoas.addAll(Arrays.asList(
            new Khoa("CNTT", "Công nghệ thông tin"),
            new Khoa("KT", "Kinh tế"),
            new Khoa("DL", "Du lịch")
        ));
    }
//    Lấy toàn bộ danh sách
    public List<Khoa> getKhoas() {
        return khoas;
    }

//    Lấy danh sách theo makh
    public Khoa getKhoa(String makh) {
        return khoas.stream().filter(khoa -> khoa.getMakh().equals(makh)).findFirst().orElse(null);
    }

//    Thêm mới 1 khoa
    public Khoa addKhoa(Khoa khoa) {
        khoas.add(khoa);
        return khoa;
    }

//    Sửa đổi thông tin khoa theo mã
    public Khoa updateKhoa(String makh, Khoa khoa) {
        Khoa check = getKhoa(makh);
        if (check == null) {
            return null;
        }
        khoas.forEach(item-> {
            if (item.getMakh() == makh) {
                item.setTenkh(khoa.getTenkh());
            }
        });
        return khoa;
    }

//    Xóa thông tin khoa theo mã
    public boolean deleteKhoa(String makh) {
        Khoa check = getKhoa(makh);
        return khoas.remove(check);
    }
}
