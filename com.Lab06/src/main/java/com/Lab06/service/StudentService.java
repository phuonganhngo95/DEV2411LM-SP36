package com.Lab06.service;

import com.Lab06.dto.StudentDTO;
import com.Lab06.entity.Student;
import com.Lab06.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    Lấy danh sách student
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

//    Tìm student theo id
    public Optional<StudentDTO> findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAge(student.getAge());
        return Optional.of(studentDTO);
    }

//    Lưu thông tin student
    public Boolean save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());

        try {
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Sửa thông tin student theo id
    public Student updateStudentById(Long id, StudentDTO updateStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updateStudent.getName());
            student.setEmail(updateStudent.getEmail());
            student.setAge(updateStudent.getAge());
            return studentRepository.save(student);
        }).orElseThrow(()-> new IllegalArgumentException("Invalid student ID: " + id));
    }

//    Xóa student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
