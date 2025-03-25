package com.example.spring.service;

import com.example.spring.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {



    public CategoryDTO saveCategory(CategoryDTO categoryDTO);

    public List<CategoryDTO> getAllCategory();

      public CategoryDTO getCategoryById(Long id);

      public void deleteCategory(Long id);
}
