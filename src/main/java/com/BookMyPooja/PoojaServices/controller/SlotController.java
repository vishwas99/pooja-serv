package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.dto.SlotAvailabilityDto;
import com.BookMyPooja.PoojaServices.entity.Slot;
import com.BookMyPooja.PoojaServices.enums.DayPart;
import com.BookMyPooja.PoojaServices.enums.SlotStatus;
import com.BookMyPooja.PoojaServices.repository.SlotRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/slots")
public class SlotController {

    private final SlotRepository slotRepository;

    protected SlotController(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @GetMapping("/provider/{providerId}")
    public List<Slot> getSlotsForProvider(@PathVariable Long providerId, @RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return slotRepository.findByProvider_providerIdAndSlotDate(providerId, parsedDate);
    }

    @GetMapping("/availability/provider/{providerId}")
    public List<SlotAvailabilityDto> getWindowsForProvider(@PathVariable Long providerId, @RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        List<Slot> slotList = slotRepository.findByProvider_providerIdAndSlotDate(providerId, parsedDate);
        Map<String, SlotAvailabilityDto> result = slotList.stream()
                .sorted((a, b) -> a.getStartTime().compareTo(b.getStartTime()))
                .collect(
                        HashMap::new,
                        (map, slot) -> {
                            for (var dayTime: DayPart.values()) {
                                if (slot.getStartTime().equals(dayTime.getDayPartStartTime())
                                    || (slot.getStartTime().isAfter(dayTime.getDayPartStartTime()) && slot.getStartTime().isBefore(dayTime.getDayPartEndTime()))
                                ) {
                                    if (map.containsKey(dayTime.name())) {
                                        SlotAvailabilityDto slotAvailabilityDto = map.get(dayTime.name());
                                        slotAvailabilityDto.setTotalSlotCount(slotAvailabilityDto.getTotalSlotCount() + 1);
                                        slotAvailabilityDto.setUnavailableSlotCount(slot.getStatus() != SlotStatus.AVAILABLE ? slotAvailabilityDto.getUnavailableSlotCount() + 1 : slotAvailabilityDto.getUnavailableSlotCount());
                                    }
                                    else {
                                        SlotAvailabilityDto slotAvailabilityDto = new SlotAvailabilityDto(dayTime.name(), dayTime.getDayPartStartTime(), dayTime.getDayPartEndTime(), 1, slot.getStatus() != SlotStatus.AVAILABLE ? 1 : 0);
                                        map.put(dayTime.name(), slotAvailabilityDto);
                                    }
                                }
                            }
                        },
                        (a, b) -> {

                        }
                );
        return result.values().stream().toList();
    }

}
