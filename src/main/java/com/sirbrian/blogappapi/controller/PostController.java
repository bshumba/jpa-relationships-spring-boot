package com.sirbrian.blogappapi.controller;

import com.sirbrian.blogappapi.dto.PostDto;
import com.sirbrian.blogappapi.response.PostResponse;
import com.sirbrian.blogappapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

   @Autowired
   private PostService postService;

//   @Autowired
//   private FileService fileService;
//
//   @Value("${project/image}")
//   private String path;

   @PostMapping("/user/{userId}/category/{categoryId}/posts")
   public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                             @PathVariable Integer userId,
                                             @PathVariable Integer categoryId) {
      PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
      return new ResponseEntity<>(createPost, HttpStatus.CREATED);
   }

   @GetMapping("/posts")
   public ResponseEntity<PostResponse> getAllPosts(
           @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
           @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
           @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
           @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
      ) {
      PostResponse allPosts = this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
      return new ResponseEntity<>(allPosts, HttpStatus.OK);
   }

//   public ResponseEntity<List<PostDto>> getAllPosts() {
//      List<PostDto> allPosts = this.postService.getAllPosts();
//      return new ResponseEntity<>(allPosts, HttpStatus.OK);
//   }
   @GetMapping("/posts/{postId}")
   public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
      PostDto postDto = this.postService.getPostById(postId);
      return new ResponseEntity<>(postDto, HttpStatus.OK);
   }

   @GetMapping("/user/{userId}/posts")
   public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {

      List<PostDto> posts = this.postService.getPostByUser(userId);
      return new ResponseEntity<>(posts, HttpStatus.OK);
   }

   @GetMapping("/category/{categoryId}/posts")
   public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {

      List<PostDto> posts = this.postService.getPostByCategory(categoryId);
      return new ResponseEntity<>(posts, HttpStatus.OK);
   }

   @PutMapping("/post/{postId}")
   public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                             @PathVariable Integer postId) {

      PostDto updatePost = this.postService.updatePost(postDto, postId);
      return new ResponseEntity<>(updatePost, HttpStatus.OK);
   }

   @DeleteMapping("/posts/{postId}")
   public ResponseEntity deletePost(@PathVariable Integer postId) {

      this.postService.deletePost(postId);
      return new ResponseEntity("Post deleted successfully!!!", HttpStatus.OK);
   }

   @GetMapping("/posts/search/{keywords}")
   public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keywords) {
      List<PostDto> result = this.postService.searchPosts(keywords);
      return new ResponseEntity<>(result, HttpStatus.OK);
   }

//   IMAGE UPLOAD
//   @PostMapping("/post/image/upload/{postId}")
//   public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image")MultipartFile image,
//                                         @PathVariable Integer postId) throws IOException {
//
//      PostDto postDto = this.postService.getPostById(postId);
//      String fileName = this.fileService.uploadImage(path, image);
//      postDto.setImageName(fileName);
//      PostDto updatedPost = this.postService.updatePost(postDto, postId);
//
//      return new ResponseEntity<>(updatedPost, HttpStatus.OK);
//   }

//   METHOD TO SERVE FILES
//   @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
//   public void downloadImage(@PathVariable("imageName") String imageName,
//                             HttpServletResponse response) throws IOException {
//
//      InputStream resource = this.fileService.getResource(path, imageName);
//      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//      StreamUtils.copy(resource, response.getOutputStream());
//   }
}
