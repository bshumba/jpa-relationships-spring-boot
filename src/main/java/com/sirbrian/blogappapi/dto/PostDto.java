package com.sirbrian.blogappapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

   private Integer postId;
   private String title;
   private String content;
   private String imageName;
   private Date addedDate;

   private CategoryDto category;

   private UserDto user;

}
