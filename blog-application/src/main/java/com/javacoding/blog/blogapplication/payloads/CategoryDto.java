package com.javacoding.blog.blogapplication.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
}
