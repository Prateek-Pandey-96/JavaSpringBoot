package com.javacoding.blog.blogapplication.services.impl;

import com.javacoding.blog.blogapplication.entities.Category;
import com.javacoding.blog.blogapplication.entities.Post;
import com.javacoding.blog.blogapplication.entities.User;
import com.javacoding.blog.blogapplication.exceptions.ResourceNotFoundException;
import com.javacoding.blog.blogapplication.payloads.PostDto;
import com.javacoding.blog.blogapplication.repositories.CategoryRepository;
import com.javacoding.blog.blogapplication.repositories.PostRepository;
import com.javacoding.blog.blogapplication.repositories.UserRepository;
import com.javacoding.blog.blogapplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto, Long userId, Integer categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", userId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<PostDto> getPostById(Long postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByUser(Long userId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByCategory(Integer categoryId) {
        return null;
    }
}
