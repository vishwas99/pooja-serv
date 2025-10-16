package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.entity.Booking;
import com.BookMyPooja.PoojaServices.entity.Slot;
import com.BookMyPooja.PoojaServices.repository.BookingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingRepository.findByCustomer_customerId(customerId);
    }

    @GetMapping("/{bookingId}/slots")
    public List<Slot> getSlotsByBookingId(@PathVariable Long bookingId) {
        return bookingRepository.findById(bookingId)
                .map(Booking::getSlot)
                .orElseGet(ArrayList::new);
    }

}
