package com.lesson03.service;

import com.lesson03.enity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    //    Mock data
    List<Employee> employees = new ArrayList<Employee>();

    public EmployeeService() {
        employees.addAll(Arrays.asList(
                new Employee(1L, "Ngô Phương Anh", "Nữ", 19, 15000),
                new Employee(2L, "Devmaster 1", "Nam", 20, 20000),
                new Employee(3L, "Devmaster 2", "None", 21, 25000)
        ));
    }
    //    Lấy toàn bộ danh sách
    public List<Employee> getEmployees() {
        return employees;
    }

    //    Lấy danh sách theo id
    public Employee getEmployee(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    //    Thêm mới 1 nhân viên
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    //    Sửa đổi thông tin nhân viên theo mã
    public Employee updateEmployee(Long id, Employee employee) {
        Employee check = getEmployee(id);
        if (check == null) {
            return null;
        }
        employees.forEach(item-> {
            if (item.getId() == id) {
                item.setId(employee.getId());
            }
        });
        return employee;
    }

    //    Xóa thông tin nhân viên theo mã
    public boolean deleteEmployee(Long id) {
        Employee check = getEmployee(id);
        return employees.remove(check);
    }
}
