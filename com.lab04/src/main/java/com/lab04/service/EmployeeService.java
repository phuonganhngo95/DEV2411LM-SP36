package com.Lab04.service;

import com.Lab04.dto.EmployeeDTO;
import com.Lab04.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<Employee>();

    public EmployeeService() {
        employeeList.add(new Employee(1L, "Employee1", "Male", 18, 10000));
        employeeList.add(new Employee(2L, "Employee2", "Female", 19, 15000));
        employeeList.add(new Employee(3L, "Employee3", "Male", 20, 20000));
        employeeList.add(new Employee(4L, "Employee4", "Female", 21, 25000));
        employeeList.add(new Employee(5L, "Employee5", "Male", 22, 30000));
    }

//    Lấy toàn bộ danh sách
    public List<Employee> findAll() {
        return employeeList;
    }

//    Lấy danh sách theo id
    public Employee getEmployee(Long id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

//    Thêm mới 1 employee
    public Boolean create(EmployeeDTO employeeDTO) {
        try {
            Employee employee = new Employee();
            employee.setId(employeeList.stream().count()+1);
            employee.setFullName(employeeDTO.getFullName());
            employee.setGender(employeeDTO.getFullName());
            employee.setAge(employeeDTO.getAge());
            employee.setSalary(employeeDTO.getSalary());
            employeeList.add(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Sửa thông tin employee theo id
    public Employee updateEmployee(Long id, Employee employee) {
        Employee check = getEmployee(id);
        if (check == null) {
            return null;
        }
        employeeList.forEach(item-> {
            if (item.getId().equals(id)) {
                item.setFullName(employee.getFullName());
                item.setGender(employee.getGender());
                item.setAge(employee.getAge());
                item.setSalary(employee.getSalary());
            }
        });
        return employee;
    }

//    Xóa thông tin employee theo id
    public boolean deleteEmployee(Long id) {
        Employee check = getEmployee(id);
        return employeeList.remove(check);
    }
}
