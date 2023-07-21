package com.sirbrian.blogappapi.service.impl;

import com.sirbrian.blogappapi.dto.UserDto;
import com.sirbrian.blogappapi.entity.User;
import com.sirbrian.blogappapi.exception.ResourceNotFoundException;
import com.sirbrian.blogappapi.repository.UserRepo;
import com.sirbrian.blogappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepo userRepo;

   @Override
   public UserDto createUser(UserDto userDto) {
      User user = this.dtoToUser(userDto);
      User savedUser = this.userRepo.save(user);
      return this.userToDto(savedUser);
   }

   @Override
   public UserDto updateUser(UserDto userDto, Integer userId) {
      User user = this.userRepo.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

      user.setName(userDto.getName());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());
      user.setAbout(userDto.getAbout());

      User updatedUser = this.userRepo.save(user);
      return this.userToDto(updatedUser);
   }

   @Override
   public UserDto getUserById(Integer userId) {
      User user = this.userRepo.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

      return this.userToDto(user);
   }

   @Override
   public List<UserDto> getAllUsers() {
      List<User> users = this.userRepo.findAll();
      List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
      return userDtos;
   }

   @Override
   public void deleteUser(Integer userId) {
      User user = this.userRepo.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
      this.userRepo.delete(user);
   }

   public User dtoToUser(UserDto userDto) {
      User user = new User();
      user.setId(userDto.getId());
      user.setName(userDto.getName());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());
      user.setAbout(userDto.getAbout());
      return user;
   }

   public UserDto userToDto(User user) {
      UserDto userDto = new UserDto();
      userDto.setId(user.getId());
      userDto.setName(user.getName());
      userDto.setEmail(user.getEmail());
      userDto.setPassword(user.getPassword());
      userDto.setAbout(user.getAbout());
      return userDto;
   }
}
