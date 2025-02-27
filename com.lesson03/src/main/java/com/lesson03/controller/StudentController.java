package com.lesson03.controller;

import com.lesson03.enity.Student;
import com.lesson03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

//    Lấy danh sách sinh viên
    @GetMapping("/student-list")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

//    Lấy thông tin sinh viên theo id
    @GetMapping("/student/{id}")
    public Student getAllStudents(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.getStudent(param);
    }

//    Thêm mới 1 sinh viên
    @PostMapping("/student-add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

//    Sửa thông tin sinh viên
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        Long param = Long.parseLong(id);
        return studentService.updateStudent(param, student);
    }

//    Xóa 1 sinh viên
    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.deleteStudent(param);
    }

}
