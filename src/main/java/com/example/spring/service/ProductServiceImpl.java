package com.example.spring.service;

import com.example.spring.dto.ProductDTO;
import com.example.spring.entity.Category;
import com.example.spring.entity.Product;
import com.example.spring.mapper.ProductMapper;
import com.example.spring.repository.CategoryRepository;
import com.example.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepository.save(ProductMapper.getProduct(productDTO, category));
        return ProductMapper.getProductDto(product);

    }


}
