package com.Lab04.service;

import com.Lab04.dto.UsersDTO;
import com.Lab04.entity.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    List<Users> usersList = new ArrayList<Users>();

    public UsersService() {
        usersList.add(new Users(1L, "user1", "pass1", "John Doe", LocalDate.parse("1990-01-01"), "john@example.com", "0123456789", 34, true));
        usersList.add(new Users(2L, "user2", "pass2", "Jane Smith", LocalDate.parse("1992-05-15"), "jane@example.com", "0987654321", 32, false));
        usersList.add(new Users(3L, "user3", "pass3", "Alice Johnson", LocalDate.parse("1985-11-22"), "alice@example.com", "1122334455", 39, true));
        usersList.add(new Users(4L, "user4", "pass4", "Bob Brown", LocalDate.parse("1988-03-18"), "bob@example.com", "1122334455", 39, true));
        usersList.add(new Users(5L, "user5", "pass5", "Charlie White", LocalDate.parse("1995-09-30"), "charlie@example.com", "4433221100", 29, false));
    }

    public List<Users> findAll() {
        return usersList;
    }

    public Boolean create(UsersDTO usersDTO) {
        try {
            Users user = new Users();
            user.setId(usersList.stream().count()+1);
            user.setUsername(usersDTO.getUsername());
            user.setPassword(usersDTO.getPassword());
            user.setEmail(usersDTO.getEmail());
            user.setFullname(usersDTO.getFullname());
            user.setPhone(usersDTO.getPhone());
            user.setAge(usersDTO.getAge());
            user.setBirthday(usersDTO.getBirthday());
            user.setStatus(usersDTO.getStatus());
            usersList.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
