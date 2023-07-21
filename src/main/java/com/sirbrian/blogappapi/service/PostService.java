package com.sirbrian.blogappapi.service;

import com.sirbrian.blogappapi.dto.PostDto;
import com.sirbrian.blogappapi.entity.Post;
import com.sirbrian.blogappapi.response.PostResponse;

import java.util.List;

public interface PostService {

   PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

   PostDto updatePost(PostDto postDto, Integer postId);

   void deletePost(Integer postId);

//   List<PostDto> getAllPosts();
   PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
   PostDto getPostById(Integer postId);

//   GET ALL POST BY CATEGORY
   List<PostDto> getPostByCategory(Integer categoryId);

//   GET ALL POST BY USER
   List<PostDto> getPostByUser(Integer userId);

//   SEARCH POSTS
   List<PostDto> searchPosts(String keyword);
}
