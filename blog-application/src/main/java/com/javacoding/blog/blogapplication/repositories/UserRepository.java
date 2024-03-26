package com.javacoding.blog.blogapplication.repositories;
import com.javacoding.blog.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
