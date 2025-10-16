package com.BookMyPooja.PoojaServices.enums;

import java.time.LocalTime;

public enum DayPart {
    MORNING(LocalTime.of(5, 0), LocalTime.of(11, 0)),
    AFTERNOON(LocalTime.of(11, 0), LocalTime.of(16, 0)),
    EVENING(LocalTime.of(16, 0), LocalTime.of(20, 0));

    private final LocalTime startTime;
    private final LocalTime endTime;

    DayPart(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getDayPartStartTime() {
        return startTime;
    }

    public LocalTime getDayPartEndTime() {
        return endTime;
    }
}
