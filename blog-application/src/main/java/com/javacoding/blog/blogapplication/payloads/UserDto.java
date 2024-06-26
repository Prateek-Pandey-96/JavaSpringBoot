package com.javacoding.blog.blogapplication.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
}
