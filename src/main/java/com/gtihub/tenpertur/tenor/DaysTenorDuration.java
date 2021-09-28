package com.gtihub.tenpertur.tenor;

import java.time.LocalDate;

public class DaysTenorDuration implements TenorDuration {
    private final int days;

    public DaysTenorDuration(int days) {
        this.days = days;
    }

    @Override
    public LocalDate addTo(LocalDate startDate) {
        return startDate.plusDays(days);
    }

    @Override
    public String toString() {
        return days + "D";
    }
}
