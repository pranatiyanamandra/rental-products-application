package com.olik.rentalapplication.service;

import com.olik.rentalapplication.dto.BookingInformationDTO;
import com.olik.rentalapplication.dto.CategoryDTO;
import com.olik.rentalapplication.dto.RentalProductDTO;
import com.olik.rentalapplication.mappers.DataMapper;
import com.olik.rentalapplication.model.BookingInformation;
import com.olik.rentalapplication.model.Category;
import com.olik.rentalapplication.model.RentalProduct;
import com.olik.rentalapplication.repo.BookingInformationRepository;
import com.olik.rentalapplication.repo.CategoryRepository;
import com.olik.rentalapplication.repo.RentalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalApplicationService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RentalProductRepository rentalProductRepository;
    @Autowired
    private BookingInformationRepository bookingInformationRepository;

    @Autowired
    private DataMapper dataMapper;
    public void addProductToCategory(String categoryName,RentalProductDTO rentalProductDTO) {
        RentalProduct rentalProduct = dataMapper.toRentalProduct(rentalProductDTO);
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        category.getRentalProductList().add(rentalProduct);
        categoryRepository.save(category);

    }



    public List<BookingInformationDTO> getListOfBookings(String categoryName, String productName) {
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        List<RentalProduct> rentalProductList = category.getRentalProductList().stream().filter(rentalProduct -> rentalProduct.getProductName().equals(productName)).collect(Collectors.toList());
        List<BookingInformationDTO> bookingInformationList = new ArrayList<>();
        for(RentalProduct rentalProduct:rentalProductList){
            List<BookingInformation> productBookingInformation =rentalProduct.getBookings();
            for(BookingInformation bookingInformation:productBookingInformation){
                bookingInformationList.add(dataMapper.toBookingInformationDTO(bookingInformation,rentalProduct.getHourlyCost()));
            }
        }
        return bookingInformationList;
    }



    public void addCategoryToRentalCatalog(CategoryDTO categoryDTO) {
        Category category = dataMapper.toCategory(categoryDTO);
        categoryRepository.save(category);
    }

    public void rentProduct(String categoryName, String productName, BookingInformationDTO bookingInformationDTO) {
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        List<RentalProduct> rentalProductList = category.getRentalProductList().stream().filter(product->product.getProductName().equals(productName)).collect(Collectors.toList());
        rentalProductList.stream().forEach(product->{
            BookingInformation bookingInformation = dataMapper.toBookingInformation(bookingInformationDTO,product.getHourlyCost());
            product.addBooking(bookingInformation);});
        categoryRepository.save(category);
    }

    public List<RentalProductDTO> getListOfAvailableProducts(String categoryName, String from, String to) {
        Timestamp fromTimeStamp = Timestamp.valueOf(from);
        Timestamp toTimeStamp = Timestamp.valueOf(to);
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        List<RentalProduct> rentalProductList = category.getRentalProductList();
        List<RentalProductDTO> rentalProductDTOList = new ArrayList<>();
        for(RentalProduct rentalProduct:rentalProductList){
            boolean available = true;
            List<BookingInformation> productBookingInformation =rentalProduct.getBookings();
            for(BookingInformation bookingInformation:productBookingInformation){
                Timestamp fromDate = bookingInformation.getFromDate();
                Timestamp toDate = bookingInformation.getToDate();
                if(toDate.after(fromTimeStamp) || fromDate.before(toTimeStamp) || toDate.equals(toTimeStamp) || fromDate.equals(fromTimeStamp)){
                    available = false;
                }
            }
            if(available){
                rentalProductDTOList.add(dataMapper.toRentalProductDTO(rentalProduct));
            }
        }
        return rentalProductDTOList;

    }

}
