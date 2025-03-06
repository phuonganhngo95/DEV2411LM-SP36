package com.Lab04.service;

import com.Lab04.dto.MonHocDTO;
import com.Lab04.entity.MonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonHocService {
    List<MonHoc> monHocList = new ArrayList<MonHoc>();

    public MonHocService() {
        monHocList.add(new MonHoc("CS", "Tin cơ sở", 45));
        monHocList.add(new MonHoc("TR", "Toán rời rạc", 50));
        monHocList.add(new MonHoc("LH", "Logic học", 55));
        monHocList.add(new MonHoc("KT", "Kĩ thuật số", 60));
        monHocList.add(new MonHoc("GT", "Giải tích", 65));
    }

//    Lấy toàn bộ danh sách
    public List<MonHoc> findAll() {
        return monHocList;
    }

//    Lấy danh sách theo mamh
    public MonHoc getMonHoc(String mamh) {
        return monHocList.stream().filter(monHoc -> monHoc.getMamh().equals(mamh)).findFirst().orElse(null);
    }

//    Thêm mới 1 môn học
    public Boolean create(MonHocDTO monHocDTO) {
        try {
            MonHoc monHoc = new MonHoc();
            monHoc.setMamh(monHocDTO.getMamh());
            monHoc.setTenmh(monHocDTO.getTenmh());
            monHoc.setSotiet(monHocDTO.getSotiet());
            monHocList.add(monHoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Sửa thông tin môn học theo mamh
    public MonHoc updateMonHoc(String mamh, MonHoc monHoc) {
        MonHoc check = getMonHoc(mamh);
        if (check == null) {
            return null;
        }
        monHocList.forEach(item-> {
            if (item.getMamh().equals(mamh)) {
                item.setTenmh(monHoc.getTenmh());
                item.setSotiet(monHoc.getSotiet());
            }
        });
        return monHoc;
    }

//    Xóa thông tin môn học theo mamh
    public boolean deleteMonHoc(String mamh) {
        MonHoc check = getMonHoc(mamh);
        return monHocList.remove(check);
    }
}
