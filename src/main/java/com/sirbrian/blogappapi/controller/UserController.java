package com.sirbrian.blogappapi.controller;

import com.sirbrian.blogappapi.dto.UserDto;
import com.sirbrian.blogappapi.repository.UserRepo;
import com.sirbrian.blogappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

   @Autowired
   private UserService userService;
   @Autowired
   private UserRepo userRepo;

   //   CREATE USER
   @PostMapping
   public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
      UserDto createUserDto = this.userService.createUser(userDto);
      return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
   }

//   UPDATE USER
   @PutMapping("/{userId}")
   public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                             @PathVariable Integer userId){
      UserDto updatedUser = this.userService.updateUser(userDto, userId);
      return new ResponseEntity<>(updatedUser, HttpStatus.OK);
   }

//   DELETE USER
   @DeleteMapping("/{userId}")
   public ResponseEntity deleteUser(@PathVariable Integer userId) {
      this.userService.deleteUser(userId);
      return new ResponseEntity("User deleted successfully", HttpStatus.OK);
   }

//   RETRIEVE ALL USERS
   @GetMapping("/")
   public ResponseEntity<List<UserDto>> getAllUsers() {
      return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
   }

//   RETRIEVE SPECIFIC USER
   @GetMapping("/{userId}")
   public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
      return new ResponseEntity<>(this.userService.getUserById(userId), HttpStatus.OK);
   }
}
