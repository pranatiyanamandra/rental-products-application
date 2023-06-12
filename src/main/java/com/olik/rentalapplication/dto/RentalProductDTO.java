package com.olik.rentalapplication.dto;

import com.olik.rentalapplication.model.BookingInformation;
import com.olik.rentalapplication.model.RentalProduct;

import java.util.ArrayList;
import java.util.List;

public class RentalProductDTO {
    private String productName;
    private String productImageUrl;
    private Integer hourlyCost;
    private List<BookingInformationDTO> bookings = new ArrayList<>();
    public RentalProductDTO() {
    }

    public RentalProductDTO(String productName, String productImageUrl, Integer hourlyCost, List<BookingInformationDTO> bookings) {
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.hourlyCost = hourlyCost;
        this.bookings = bookings;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Integer getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(Integer hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public List<BookingInformationDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInformationDTO> bookings) {
        this.bookings = bookings;
    }
}
