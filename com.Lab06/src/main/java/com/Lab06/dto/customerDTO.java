package com.Lab06.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class customerDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String birthDay;
    private Boolean active;
}
