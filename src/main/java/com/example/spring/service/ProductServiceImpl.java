package com.example.spring.service;

import com.example.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;





}
