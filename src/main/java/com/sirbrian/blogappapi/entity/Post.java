package com.sirbrian.blogappapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer postId;
   @Column(name="post_title", nullable = false)
   private String title;
   private String content;
   private String imageName;
   private Date addedDate;

   @ManyToOne
   @JoinColumn(name="category_id")
   private Category category;

   @ManyToOne
   private User user;

}
