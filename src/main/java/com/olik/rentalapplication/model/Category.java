package com.olik.rentalapplication.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    List<RentalProduct> rentalProductList = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryName, List<RentalProduct> rentalProductList) {
        this.categoryName = categoryName;
        this.rentalProductList = rentalProductList;
    }

    public Category(Integer id, String categoryName, List<RentalProduct> rentalProductList) {
        this.id = id;
        this.categoryName = categoryName;
        this.rentalProductList = rentalProductList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<RentalProduct> getRentalProductList() {
        return rentalProductList;
    }

    public void setRentalProductList(List<RentalProduct> rentalProductList) {
        this.rentalProductList = rentalProductList;
    }
    public void addRentalProduct(RentalProduct rentalProduct) {
        this.rentalProductList.add(rentalProduct);
    }
}
