package com.lesson03.service;

//Service class: SstudentService
//<p>Lớp dịch vụ thực hiện các chức năng thao tác với List Object Student</p>

import com.lesson03.enity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
//    Mock data
    List<Student> students = new ArrayList<Student>();

    public StudentService() {
        students.addAll(Arrays.asList(
                new Student(1L, "Devmaster Academy", 20, "None", "Số 25 Vũ Ngọc Phan", "0978611889", "@gmail.com"),
                new Student(2L, "Devmaster 2", 21, "Nam", "25 VNP", "0123456789", "@gmail.com"),
                new Student(3L, "Devmaster3", 22, "Nữ", "VNP", "0954353643", "@gmailcom")
        ));
    }

//    Láy toàn bộ danh sách sinh viên
    public List<Student> getStudents() {
        return students;
    }

//    Lấy sinh viên theo id
    public Student getStudent(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

//    Thêm mới 1 sinh viên
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

//    Cập nhật thông tin sinh viên
    public Student updateStudent(Long id, Student student) {
        Student check = getStudent(id);
        if (check == null) {
            return null;
        }
        students.forEach(item-> {
            if (item.getId() == id) {
                item.setName(student.getName());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
                item.setAddress(student.getAddress());
                item.setPhone(student.getPhone());
                item.setEmail(student.getEmail());
            }
        });
        return student;
    }

//    Xóa thông tin sinh viên
    public boolean deleteStudent(Long id) {
        Student check = getStudent(id);
        return students.remove(check);
    }
}
