package com.example.spring.service;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.entity.Category;
import com.example.spring.exception.CategoryAlreadyExistException;
import com.example.spring.mapper.CategoryMapper;
import com.example.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {

        Optional<Category> isAvaiable = categoryRepository.findByName(categoryDTO.getName());

        if (isAvaiable.isPresent()) {
            throw new CategoryAlreadyExistException
                    ("Duplicate " + categoryDTO.getName() +  " already exist");
        }

        Category category = CategoryMapper.getCategory(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.getCategoryDTO(category);

    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(sp -> CategoryMapper.getCategoryDTO(sp)).toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.getCategoryDTO(category);
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        Optional<Category> isAvailable = categoryRepository.findById(id);
        if (isAvailable.isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

