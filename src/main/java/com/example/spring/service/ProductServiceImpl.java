package com.example.spring.service;

import com.example.spring.dto.ProductDTO;
import com.example.spring.entity.Category;
import com.example.spring.entity.Product;
import com.example.spring.mapper.ProductMapper;
import com.example.spring.repository.CategoryRepository;
import com.example.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Id not avaiable"));
        Product product = ProductMapper.getProduct(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.getProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return product.stream().map(p -> ProductMapper.getProductDTO(p)).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not found"));
        return ProductMapper.getProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        product = productRepository.save(product);
        return ProductMapper.getProductDTO(product);
    }

    @Override
    public ProductDTO partiallyUpdateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));


        if (productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if (productDTO.getPrice() != null) {
            product.setPrice(productDTO.getPrice());
        }
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Given Category not found"));
            product.setCategory(category);
        }
        product = productRepository.save(product);
        return ProductMapper.getProductDTO(product);
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not avaiable"));
        productRepository.deleteById(id);
        return true;
    }


}
