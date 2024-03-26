package com.javacoding.blog.blogapplication.repositories;

import com.javacoding.blog.blogapplication.entities.Category;
import com.javacoding.blog.blogapplication.entities.Post;
import com.javacoding.blog.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findBy(User user);
//    List<Post> findByCategory(Category category);
}
