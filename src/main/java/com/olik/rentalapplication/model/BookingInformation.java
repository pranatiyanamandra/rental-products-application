package com.olik.rentalapplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Entity
@Table(name = "booking_information")
public class BookingInformation {

    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private Integer bookingId;
    @Column(name = "from_date")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Timestamp fromDate;
    @Column(name="to_date")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Timestamp toDate;
    @Column(name = "total_hours_rented")
    private Long totalHoursRented;

    @Column(name = "cost_for_duration")
    private Long costForDuration;

    public BookingInformation() {
    }

    public BookingInformation(Timestamp fromDate, Timestamp toDate, Long totalHoursRented,Integer hourlyCost) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalHoursRented = totalHoursRented;
        this.costForDuration = totalHoursRented*hourlyCost;
    }

    public BookingInformation(Timestamp fromDate, Timestamp toDate,Integer hourlyCost) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        long milliseconds = toDate.getTime() - fromDate.getTime();
        long seconds = milliseconds / 1000;
        this.totalHoursRented = seconds/3600;
        this.costForDuration = totalHoursRented*hourlyCost;

    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Long getCostForDuration() {
        return costForDuration;
    }

    public void setCostForDuration(Long costForDuration) {
        this.costForDuration = costForDuration;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Long getTotalHoursRented() {
        return totalHoursRented;
    }

    public void setTotalHoursRented(Long totalHoursRented) {
        this.totalHoursRented = totalHoursRented;
    }
}
