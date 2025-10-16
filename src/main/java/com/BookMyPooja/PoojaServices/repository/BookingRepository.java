package com.BookMyPooja.PoojaServices.repository;

import com.BookMyPooja.PoojaServices.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomer_customerId(Long customerId);
}
