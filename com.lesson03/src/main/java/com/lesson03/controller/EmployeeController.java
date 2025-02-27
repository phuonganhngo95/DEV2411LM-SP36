package com.lesson03.controller;

import com.lesson03.enity.Employee;
import com.lesson03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //    Lấy danh sách nhân viên
    @GetMapping("/employee-list")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    //    Lấy thông tin nhân viên theo id
    @GetMapping("/employee/{id}")
    public Employee getAllEmployees(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return employeeService.getEmployee(param);
    }

    //    Thêm mới 1 nhân viên
    @PostMapping("/employee-add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    //    Sửa thông tin nhân viên
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Long param = Long.parseLong(id);
        return employeeService.updateEmployee(param, employee);
    }

    //    Xóa 1 nhân viên
    @DeleteMapping("/employee/{id}")
    public boolean deleteEmployee(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return employeeService.deleteEmployee(param);
    }

}
