package com.BookMyPooja.PoojaServices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlotAvailabilityDto {

    private String slotType;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalSlotCount;
    private int unavailableSlotCount;

}
