package com.olik.rentalapplication.repo;

import com.olik.rentalapplication.model.BookingInformation;
import org.springframework.data.repository.CrudRepository;

public interface BookingInformationRepository extends CrudRepository<BookingInformation,Integer> {
}
