package com.gtihub.tenpertur.tenor;

import java.time.LocalDate;

public interface TenorDuration {
    LocalDate addTo(LocalDate startDate);
}
