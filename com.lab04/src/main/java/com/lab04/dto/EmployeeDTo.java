package com.Lab04.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    Long id;

    @Size(min = 3, max = 25, message = "FullName must be between 3 and 25 characters")
    String fullName;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must be least than or equal to 60")
    int age;

    @Min(value = 0, message = "Salary must be greater than 0")
    double salary;
}
