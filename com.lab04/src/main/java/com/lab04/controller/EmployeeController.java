package com.Lab04.controller;

import com.Lab04.dto.EmployeeDTO;
import com.Lab04.entity.Employee;
import com.Lab04.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

//    Lấy danh sách employee
    @GetMapping("/employee-list")
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

//    Lấy thông tin employee theo id
    @GetMapping("/employee/{id}")
    public Employee getAllEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

//    Thêm mới 1 employee
    @PostMapping("/employee-add")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
        employeeService.create(employee);
        return ResponseEntity.badRequest().body("Employee created successfully");
    }

//    Sửa thông tin employee
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

//    Xóa thông tin employee theo id
    @DeleteMapping("/employee/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
