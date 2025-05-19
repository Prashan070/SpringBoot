package com.example.spring.service;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.entity.Category;
import com.example.spring.mapper.CategoryMapper;
import com.example.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.getCategory(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.getCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> CategoryMapper.getCategoryDTO(category)).toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Caterogy not found"));
        return CategoryMapper.getCategoryDTO(category);

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}

