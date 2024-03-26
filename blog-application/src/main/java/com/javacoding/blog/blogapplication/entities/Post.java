package com.javacoding.blog.blogapplication.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
