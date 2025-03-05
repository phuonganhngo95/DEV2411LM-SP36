package com.Lab05.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Info {
    private String name;
    private String nickName;
    private String email;
    private String website;
}
