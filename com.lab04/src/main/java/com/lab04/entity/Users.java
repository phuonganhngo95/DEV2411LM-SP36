package com.Lab04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
