package com.gtihub.tenpertur;

import com.gtihub.tenpertur.tenor.TenorDuration;
import com.gtihub.tenpertur.date.DateService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("date")
public class MaturityDateResource {
    private final DateService dateService;

    @Inject
    public MaturityDateResource(DateService dateService) {
        this.dateService = dateService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public LocalDate date(
            @QueryParam("from") LocalDate fromDate,
            @QueryParam("duration") TenorDuration duration
            ) {
        return dateService.calculateMaturityDate(fromDate, duration);
    }
}