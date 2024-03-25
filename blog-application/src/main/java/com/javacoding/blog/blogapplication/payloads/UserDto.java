package com.javacoding.blog.blogapplication.payloads;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}
