package com.example.spring.controller;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.saveCategory(categoryDTO), HttpStatus.CREATED);
    }


    //get all category
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.FOUND);
    }

    //get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.FOUND);
    }


    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category deleted", HttpStatus.OK);

    }




}
