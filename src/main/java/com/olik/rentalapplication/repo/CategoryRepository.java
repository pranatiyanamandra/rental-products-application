package com.olik.rentalapplication.repo;

import com.olik.rentalapplication.model.Category;
import com.olik.rentalapplication.model.RentalProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    public Optional<Category> findByCategoryName(String categoryName);

}
