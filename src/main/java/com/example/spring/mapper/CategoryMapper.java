package com.example.spring.mapper;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.entity.Category;

public class CategoryMapper {


    public static Category getCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }


    public static CategoryDTO getCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProduct(category.getProducts().stream().map(product -> ProductMapper.getProductDTO(product)).toList());
        return categoryDTO;
    }
}
