package com.olik.rentalapplication.mappers;

import com.olik.rentalapplication.dto.BookingInformationDTO;
import com.olik.rentalapplication.dto.CategoryDTO;
import com.olik.rentalapplication.dto.RentalProductDTO;
import com.olik.rentalapplication.model.BookingInformation;
import com.olik.rentalapplication.model.Category;
import com.olik.rentalapplication.model.RentalProduct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataMapper {
    public RentalProduct toRentalProduct(RentalProductDTO rentalProductDTO){
        List<BookingInformation> bookingInformationList = rentalProductDTO.getBookings().stream().map(booking->toBookingInformation(booking,rentalProductDTO.getHourlyCost())).collect(Collectors.toList());
        return new RentalProduct(rentalProductDTO.getProductName(),rentalProductDTO.getProductImageUrl(),rentalProductDTO.getHourlyCost(),bookingInformationList);
    }

    public RentalProductDTO toRentalProductDTO(RentalProduct rentalProduct){
        List<BookingInformationDTO> bookingInformationDTOList= rentalProduct.getBookings().stream().map(booking->toBookingInformationDTO(booking,rentalProduct.getHourlyCost())).collect(Collectors.toList());
        return new RentalProductDTO(rentalProduct.getProductName(), rentalProduct.getProductImageUrl(), rentalProduct.getHourlyCost(),bookingInformationDTOList);

    }
    public BookingInformation toBookingInformation(BookingInformationDTO bookingInformationDTO,Integer hourlyCost){

        return new BookingInformation(bookingInformationDTO.getFromDate(),bookingInformationDTO.getToDate(),hourlyCost);
    }

    public BookingInformationDTO toBookingInformationDTO(BookingInformation bookingInformation,Integer hourlyCost){
        return new BookingInformationDTO(bookingInformation.getFromDate(),bookingInformation.getToDate(),hourlyCost);
    }

    public CategoryDTO toCategoryDTO(Category category){
        List<RentalProductDTO> rentalProductDtosList = category.getRentalProductList().stream().map(rentalProduct -> toRentalProductDTO(rentalProduct)).collect(Collectors.toList());
        CategoryDTO categoryDTO = new CategoryDTO(category.getCategoryName(),rentalProductDtosList);
        return categoryDTO;
    }
    public Category toCategory(CategoryDTO categoryDTO){
        List<RentalProduct> rentalProductList = categoryDTO.getRentalProductList().stream().map(rentalProductDto -> toRentalProduct(rentalProductDto)).collect(Collectors.toList());
        Category category = new Category(categoryDTO.getCategoryName(),rentalProductList);
        return category;
    }


}
