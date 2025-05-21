package com.example.spring.service;

import com.example.spring.dto.ProductDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ProductService {


    public ProductDTO saveProduct(ProductDTO productDTO);


    public List<ProductDTO> getAllProduct();

    public ProductDTO getProductById(Long id);


    public ProductDTO updateProduct(Long id, ProductDTO productDTO);


    public ProductDTO partiallyUpdateProduct(Long id, ProductDTO productDTO);

    public boolean deleteCategoryById(Long id);
}
