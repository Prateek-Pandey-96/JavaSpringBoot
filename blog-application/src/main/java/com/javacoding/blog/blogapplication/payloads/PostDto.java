package com.javacoding.blog.blogapplication.payloads;
import com.javacoding.blog.blogapplication.entities.Category;
import com.javacoding.blog.blogapplication.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostDto{
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
}
