package com.javacoding.blog.blogapplication.services;

import com.javacoding.blog.blogapplication.entities.Post;
import com.javacoding.blog.blogapplication.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Long userId, Integer categoryId);
    PostDto updatePost(PostDto postDto);
    void deletePost(Long postId);
    List<PostDto> getPostById(Long postId);
    List<PostDto> getAllPosts();
    List<PostDto> getAllPostsByUser(Long userId);
    List<PostDto> getAllPostsByCategory(Integer categoryId);
}
