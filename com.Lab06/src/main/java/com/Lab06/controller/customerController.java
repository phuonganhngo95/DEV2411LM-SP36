package com.Lab06.controller;

import com.Lab06.dto.customerDTO;
import com.Lab06.entity.customer;
import com.Lab06.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class customerController {
    @Autowired
    private customerService customerService;

    public customerController(customerService customerService) {
        this.customerService = customerService;
    }

    //    Lấy danh sách customer
    @GetMapping
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/customer-list";
    }

    //    Tạo thông tin customer
    @GetMapping("/add-new")
    public String addNewCustomer(Model model) {
        model.addAttribute("customer", new customer());
        return "customers/customer-add";
    }

    //    Sửa thông tin customer
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        customerDTO customer = customerService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid customer ID: " + id));
        model.addAttribute("customer", customer);
        return "customers/customer-edit";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute("customer") customerDTO customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping
    public String updateCustomer(@PathVariable(value = "id") Long id, @ModelAttribute("customer") customerDTO customer) {
        customerService.updateCustomerById(id, customer);
        return "redirect:/customers";
    }

    //    Xóa thông tin customer
    public String deleteCustomer(@PathVariable(value = "id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
