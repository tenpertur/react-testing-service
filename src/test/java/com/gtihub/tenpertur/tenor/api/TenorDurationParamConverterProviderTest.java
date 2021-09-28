package com.gtihub.tenpertur.tenor.api;

import com.gtihub.tenpertur.tenor.DaysTenorDuration;
import com.gtihub.tenpertur.tenor.TenorDuration;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.ws.rs.ext.ParamConverter;
import java.lang.annotation.Annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TenorDurationParamConverterProviderTest {
    ParamConverter<TenorDuration> provider = new TenorDurationParamConverterProvider()
            .getConverter(TenorDuration.class, TenorDuration.class.getGenericSuperclass(), new Annotation[]{});
    @Test
    public void shouldConvert_21d(){
        var tenorDuration = provider.fromString("21d");
        assertThat(tenorDuration, Matchers.is(Matchers.instanceOf(DaysTenorDuration.class)));
        assertThat(tenorDuration.toString(), Matchers.equalTo("21D"));
    }

}