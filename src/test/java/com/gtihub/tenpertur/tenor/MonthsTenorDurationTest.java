package com.gtihub.tenpertur.tenor;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

class MonthsTenorDurationTest {
    TenorDuration tenorDuration = new MonthsTenorDuration(3);
    @Test
    void testToString() {
        assertThat(tenorDuration.toString(), Matchers.equalTo("3M"));
    }

    @Test
    void addToOrdinaryDay() {
        assertThat(tenorDuration.addTo(LocalDate.parse("2021-08-10")), Matchers.equalTo(LocalDate.parse("2021-11-10")));
    }
    @Test
    void addToLastDayOfMonth() {
        assertThat(new MonthsTenorDuration(12).addTo(LocalDate.parse("2023-02-28")), Matchers.equalTo(LocalDate.parse("2024-02-29")));
    }
}