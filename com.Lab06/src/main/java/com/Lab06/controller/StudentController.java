package com.Lab06.controller;

import com.Lab06.dto.StudentDTO;
import com.Lab06.entity.Student;
import com.Lab06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    Lấy danh sách student
    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/student-list";
    }

//    Tạo thông tin student
    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/student-add";
    }

//    Sửa thông tin student
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        StudentDTO student = studentService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        return "students/student-edit";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping
    public String updateStudent(@PathVariable(value = "id") Long id, @ModelAttribute("student") StudentDTO student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

//    Xóa thông tin student
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
