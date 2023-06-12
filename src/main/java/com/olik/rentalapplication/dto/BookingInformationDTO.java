package com.olik.rentalapplication.dto;

import java.sql.Timestamp;

public class BookingInformationDTO {
    private Timestamp fromDate;

    private Timestamp toDate;
    private Long totalHoursRented;
    private Long costForDuration;

    public BookingInformationDTO() {
    }

    public BookingInformationDTO(Timestamp fromDate, Timestamp toDate,Integer hourlyCost) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        long milliseconds = toDate.getTime() - fromDate.getTime();
        long seconds = milliseconds / 1000;
        this.totalHoursRented = seconds/3600;
        this.costForDuration = totalHoursRented*hourlyCost;
    }

    public BookingInformationDTO(Timestamp fromDate, Timestamp toDate, Long totalHoursRented,Integer hourlyCost) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalHoursRented = totalHoursRented;
        this.costForDuration = totalHoursRented*hourlyCost;
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
