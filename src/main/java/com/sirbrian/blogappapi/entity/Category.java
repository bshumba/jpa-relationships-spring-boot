package com.sirbrian.blogappapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer categoryId;
   @Column(name="title", nullable = false)
   @NotBlank
   @Size(min = 2, message = "title can not have less than 2 characters")
   private String categoryTitle;
   @Column(name="description")
   @NotBlank
   @Size(min = 5, message = "description can not have less than 5 characters")
   private String categoryDescription;

   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Post> posts = new ArrayList<>();
}
