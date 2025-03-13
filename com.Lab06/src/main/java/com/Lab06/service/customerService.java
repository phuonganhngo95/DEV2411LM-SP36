package com.Lab06.service;

import com.Lab06.dto.customerDTO;
import com.Lab06.entity.customer;
import com.Lab06.repository.customerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class customerService {
    private customerRepository customerRepository;

    @Autowired
    public customerService(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //    Lấy danh sách customer
    public List<customer> findAll() {
        return customerRepository.findAll();
    }

    //    Tìm customer theo id
    public Optional<customerDTO> findById(Long id) {
        customer customer= customerRepository.findById(id).orElse(null);
        customerDTO customerDTO = new customerDTO();
        customerDTO.setId(id);
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setFullName(customer.getFullName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setBirthDay(customer.getBirthDay());
        customerDTO.setActive(customer.getActive());
        return Optional.of(customerDTO);
    }

    //    Lưu thông tin customer
    public Boolean save(customerDTO customerDTO) {
        customer customer = new customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setFullName(customerDTO.getFullName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setBirthDay(customerDTO.getBirthDay());
        customer.setActive(customerDTO.getActive());

        try {
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //    Sửa thông tin customer theo id
    public customer updateCustomerById(Long id, customerDTO updateCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setUsername(updateCustomer.getUsername());
            customer.setPassword(updateCustomer.getPassword());
            customer.setFullName(updateCustomer.getFullName());
            customer.setAddress(updateCustomer.getAddress());
            customer.setPhone(updateCustomer.getPhone());
            customer.setEmail(updateCustomer.getEmail());
            customer.setBirthDay(updateCustomer.getBirthDay());
            customer.setActive(updateCustomer.getActive());
            return customerRepository.save(customer);
        }).orElseThrow(()-> new IllegalArgumentException("Invalid student ID: " + id));
    }

    //    Xóa student
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
