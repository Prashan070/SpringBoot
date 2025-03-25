package com.example.spring.dto;

import com.example.spring.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductDTO {


    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long CategoryId;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public ProductDTO(Long id, String name, String description, Double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        CategoryId = categoryId;
    }

    public ProductDTO() {
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", CategoryId=" + CategoryId +
                '}';
    }
}
