package com.Lab04.service;

import com.Lab04.dto.KhoaDTO;
import com.Lab04.entity.Khoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhoaService {
    List<Khoa> khoaList = new ArrayList<Khoa>();

    public KhoaService() {
        khoaList.add(new Khoa("CNTT", "Công nghệ thông tin"));
        khoaList.add(new Khoa("KT", "Kinh tế"));
        khoaList.add(new Khoa("DL", "Du lịch"));
        khoaList.add(new Khoa("NN", "Ngoại ngữ"));
        khoaList.add(new Khoa("CK", "Cơ khí"));
    }

//    Lấy toàn bộ danh sách
    public List<Khoa> findAll() {
        return khoaList;
    }

//    Lấy danh sách theo makh
    public Khoa getKhoa(String makh) {
        return khoaList.stream().filter(khoa -> khoa.getMakh().equals(makh)).findFirst().orElse(null);
    }

//    Thêm mới 1 khoa
    public Boolean create(KhoaDTO khoaDTO) {
        try {
            Khoa khoa = new Khoa();
            khoa.setMakh(khoaDTO.getMakh());
            khoa.setTenkh(khoaDTO.getTenkh());
            khoaList.add(khoa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Sửa thông tin khoa theo makh
    public Khoa updateKhoa(String makh, Khoa khoa) {
        Khoa check = getKhoa(makh);
        if (check == null) {
            return null;
        }
        khoaList.forEach(item-> {
            if (item.getMakh().equals(makh)) {
                item.setTenkh(khoa.getTenkh());
            }
        });
        return khoa;
    }

//    Xóa thông tin khoa theo makh
    public boolean deleteKhoa(String makh) {
        Khoa check = getKhoa(makh);
        return khoaList.remove(check);
    }
}
