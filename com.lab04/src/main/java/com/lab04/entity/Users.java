package com.lab04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@FieldDefaults(level =  = AccessLevel.PRIVATE)
//@Entity
public class Users {
    Long id;
    String username;
    String password;
    String fullname;
    LocalDate birthday;
    String email;
    String phone;
    int age;
    Boolean status;
}
