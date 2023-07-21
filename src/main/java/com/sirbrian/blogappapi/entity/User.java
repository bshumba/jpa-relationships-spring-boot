package com.sirbrian.blogappapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue
   private int id;
   @Column(name = "user_name", nullable = false)
   private String name;
   private String email;
   private String password;
   private String about;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Post> posts = new ArrayList<>();
}
