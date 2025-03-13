package com.Lab06.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
}
