package com.sirbrian.blogappapi.controller;

import com.sirbrian.blogappapi.dto.CategoryDto;
import com.sirbrian.blogappapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

   @Autowired
   private CategoryService categoryService;

   @PostMapping
   public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

      CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
      return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
   }

   @PutMapping("/{catId}")
   public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                     @PathVariable Integer catId) {
      CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
      return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
   }

   @DeleteMapping("/{catId}")
   public ResponseEntity deleteCategory(@PathVariable Integer catId) {

      this.categoryService.deleteCategory(catId);
      return new ResponseEntity("Category deleted successfully", HttpStatus.OK);
   }

   @GetMapping("/{catId}")
   public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {

      CategoryDto categoryDto = this.categoryService.getCategory(catId);
      return new ResponseEntity<>(categoryDto, HttpStatus.OK);
   }

   @GetMapping("/")
   public ResponseEntity<List<CategoryDto>> getCategories() {
       List<CategoryDto> categories = this.categoryService.getCategories();
       return new ResponseEntity<>(categories, HttpStatus.OK);
   }
}
