package com.Lab04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonHoc {
    String mamh;
    String tenmh;
    int sotiet;
}
