package com.gtihub.tenpertur.date;

import com.gtihub.tenpertur.tenor.TenorDuration;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

@ApplicationScoped
public class DateService {
    public LocalDate  calculateMaturityDate(LocalDate startDate, TenorDuration duration){
        return duration.addTo(startDate);
    }
}
