package com.example.spring.controller;

import com.example.spring.dto.CategoryDTO;
import com.example.spring.dto.ProductDTO;
import com.example.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    //create Product
    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO ){
        return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.CREATED);
    }


    //get all Product

    //get Product by id

    //delete Product


}
