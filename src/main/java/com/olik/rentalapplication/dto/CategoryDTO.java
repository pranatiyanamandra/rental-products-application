package com.olik.rentalapplication.dto;

import com.olik.rentalapplication.model.RentalProduct;
import jakarta.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private String categoryName;
    private List<RentalProductDTO> rentalProductList = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryName, List<RentalProductDTO> rentalProductList) {
        this.categoryName = categoryName;
        this.rentalProductList = rentalProductList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<RentalProductDTO> getRentalProductList() {
        return rentalProductList;
    }

    public void setRentalProductList(List<RentalProductDTO> rentalProductList) {
        this.rentalProductList = rentalProductList;
    }
}
