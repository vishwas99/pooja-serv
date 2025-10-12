package com.BookMyPooja.PoojaServices.entity;

import com.BookMyPooja.PoojaServices.enums.SlotStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "slot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    private Date date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated
    private SlotStatus status = SlotStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void updateTimestamps() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        updatedAt = LocalDateTime.now();
    }
}
