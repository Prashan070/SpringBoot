package com.example.spring.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
public class CategoryDTO {


    private Long id;
    private String name;
    private List<ProductDTO> product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDTO> product) {
        this.product = product;
    }

    public CategoryDTO(Long id, String name, List<ProductDTO> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public CategoryDTO() {
    }
}
