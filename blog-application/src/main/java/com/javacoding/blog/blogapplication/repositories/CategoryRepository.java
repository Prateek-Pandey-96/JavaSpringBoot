package com.javacoding.blog.blogapplication.repositories;

import com.javacoding.blog.blogapplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
