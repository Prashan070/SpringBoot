package com.example.spring.mapper;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.dto.ProductDTO;
import com.example.spring.entity.Category;
import com.example.spring.entity.Product;

public class ProductMapper {


    public static Product getProduct(ProductDTO productDTO,Category category) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        return product;

    }


    public static ProductDTO getProductDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );

    }


}
