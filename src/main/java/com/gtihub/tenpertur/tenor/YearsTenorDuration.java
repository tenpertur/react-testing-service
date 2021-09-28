package com.gtihub.tenpertur.tenor;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class YearsTenorDuration implements TenorDuration {
    final int years;

    public YearsTenorDuration(int years) {
        this.years = years;
    }

    @Override
    public LocalDate addTo(LocalDate startDate) {

        var endOfMonth = startDate.equals(startDate.with(TemporalAdjusters.lastDayOfMonth()));
        if (endOfMonth){
            return startDate.plusYears(years).with(TemporalAdjusters.lastDayOfMonth());
        } else {
            return startDate.plusYears(years);
        }
    }

    @Override
    public String toString() {
        return years + "Y";
    }
}
