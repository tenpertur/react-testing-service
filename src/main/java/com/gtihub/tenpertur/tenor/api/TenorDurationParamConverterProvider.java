package com.gtihub.tenpertur.tenor.api;

import com.gtihub.tenpertur.tenor.*;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.regex.Pattern;

@Provider
public class TenorDurationParamConverterProvider implements ParamConverterProvider {
    final Pattern pattern = Pattern.compile("^(([1-9])|([1-9][0-9]*))([dwmy]|[DWMY])$");
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (!TenorDuration.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new ParamConverter<T>() {
            @Override
            public T fromString(String value) {
                if (value == null || value.isEmpty() || value.isBlank()) {
                    return null;
                }
                if (!pattern.matcher(value).matches()){
                    return null;
                }
                int val = Integer.parseInt(value, 0, value.length()-1, 10);
                switch (value.toLowerCase(Locale.ROOT).charAt(value.length()-1)){
                    case 'd':
                        return  rawType.cast(new DaysTenorDuration(val));
                    case 'w':
                        rawType.cast(new WeeksTenorDuration(val));
                    case 'm':
                        return  rawType.cast(new MonthsTenorDuration(val));
                    case 'y':
                        return rawType.cast(new YearsTenorDuration(val));
                    default:
                        return null;
                }
            }

            @Override
            public String toString(T value) {
                if (value instanceof TenorDuration){
                    return value.toString();
                }
                return null;
            }
        };
    }
}
