package com.gtihub.tenpertur.tenor;

import java.time.LocalDate;

public class WeeksTenorDuration implements TenorDuration{
    private final int weeks;

    public WeeksTenorDuration(int weeks) {
        this.weeks = weeks;
    }

    @Override
    public LocalDate addTo(LocalDate startDate) {
        return null;
    }

    @Override
    public String toString() {
        return weeks+"W";
    }
}
