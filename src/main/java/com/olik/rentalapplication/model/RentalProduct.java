package com.olik.rentalapplication.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class RentalProduct {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer id;

    @Column(name="product_name")
    private String productName;

    @Column(name = "product_image_url")
    private String productImageUrl;

    @Column(name = "hourly_cost")
    private Integer hourlyCost;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<BookingInformation> bookings = new ArrayList<>();



    public RentalProduct() {
    }

    public RentalProduct(String productName, String productImageUrl, Integer hourlyCost, List<BookingInformation> bookings) {
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.hourlyCost = hourlyCost;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<BookingInformation> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInformation> bookings) {
        this.bookings = bookings;
    }
    public void addBooking(BookingInformation bookingInformation) {
        this.bookings.add(bookingInformation);
    }
}
