package com.Lab04.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonHocDTO {
    @Pattern(regexp = "[A-Za-z]{2}", message = "Mamh must contain 2 letter")
    String mamh;

    @Size(min = 5, max = 50, message = "Tenmh must be between 5 and 50 characters")
    String tenmh;

    @Min(value = 45, message = "Sotiet must be at least 45")
    @Max(value = 75, message = "Sotiet must be least than or equal to 75")
    int sotiet;
}
