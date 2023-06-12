package com.olik.rentalapplication.controller;

import com.olik.rentalapplication.dto.BookingInformationDTO;
import com.olik.rentalapplication.dto.CategoryDTO;
import com.olik.rentalapplication.dto.RentalProductDTO;
import com.olik.rentalapplication.service.RentalApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RentalApplicationController {
    @Autowired
    private RentalApplicationService rentalApplicationService;
    //Add products to the category
    @PostMapping("/{name}/add-product")
    public void addProductToCategory(@PathVariable String name,@RequestBody RentalProductDTO rentalProductDTO){
        rentalApplicationService.addProductToCategory(name,rentalProductDTO);
    }
    //Add categories
    @PostMapping("/add-category")
    public void addCategoryToRentalCatalog(@RequestBody CategoryDTO categoryDTO){
        rentalApplicationService.addCategoryToRentalCatalog(categoryDTO);
    }

    //book a product in a particular category for a duration
    @PostMapping("/{categoryName}/{productName}/add-booking")
    public void rentProduct(@PathVariable String categoryName,@PathVariable String productName,@RequestBody BookingInformationDTO bookingInformationDTO){
        rentalApplicationService.rentProduct(categoryName,productName,bookingInformationDTO);
    }

    //obtain a list of bookings for a product in a category
    @GetMapping("/{categoryName}/{productName}/get-booking")
    public List<BookingInformationDTO> getListOfBookings(@PathVariable String categoryName,@PathVariable String productName){
        return rentalApplicationService.getListOfBookings(categoryName,productName);
    }

    //obtain a list of available products in a category for a duration
    @GetMapping("/{categoryName}")
    public List<RentalProductDTO> getListOfAvailableProducts(@PathVariable String categoryName, @RequestParam String from,@RequestParam String to){
        return rentalApplicationService.getListOfAvailableProducts(categoryName,from,to);
    }


}
