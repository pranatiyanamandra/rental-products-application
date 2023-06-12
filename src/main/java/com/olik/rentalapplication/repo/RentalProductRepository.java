package com.olik.rentalapplication.repo;

import com.olik.rentalapplication.model.RentalProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RentalProductRepository extends CrudRepository<RentalProduct,Integer> {
    public Optional<RentalProduct> findByProductName(String productName);
}
