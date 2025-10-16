package com.BookMyPooja.PoojaServices.repository;

import com.BookMyPooja.PoojaServices.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    public List<Slot> findByProvider_providerIdAndSlotDate(Long providerId, LocalDate date);
}
