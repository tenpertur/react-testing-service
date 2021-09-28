package com.gtihub.tenpertur.tenor;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class MonthsTenorDuration implements TenorDuration {
    final int months;

    public MonthsTenorDuration(int months) {
        this.months = months;
    }

    @Override
    public LocalDate addTo(LocalDate startDate) {

        var endOfMonth = startDate.equals(startDate.with(TemporalAdjusters.lastDayOfMonth()));
        if (endOfMonth){
            return startDate.plusMonths(months).with(TemporalAdjusters.lastDayOfMonth());
        } else {
            return startDate.plusMonths(months);
        }
    }

    @Override
    public String toString() {
        return months + "M";
    }
}
