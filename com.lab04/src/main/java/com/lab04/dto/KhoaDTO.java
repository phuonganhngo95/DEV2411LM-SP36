package com.Lab04.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhoaDTO {
    @NotBlank(message = "Makh cannot be blank")
    @Size(min = 2, message = "Makh must be at least 2 letter")
    String makh;

    @Size(min = 5, max = 25, message = "Tenkh must be between 5 and 25 characters")
    String tenkh;
}
