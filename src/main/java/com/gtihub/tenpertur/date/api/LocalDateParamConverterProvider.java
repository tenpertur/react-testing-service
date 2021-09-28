package com.gtihub.tenpertur.date.api;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Provider
public class LocalDateParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType,
                                              Annotation[] annotations) {
        if (rawType.getName().equals(java.time.LocalDate.class.getName())) {
            return new ParamConverter<>() {
                @Override
                public T fromString(String value) {
                    if (value == null || value.isEmpty()) {
                        return null;
                    }
                    return rawType.cast(LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE));
                }

                @Override
                public String toString(T value) {
                    if (value instanceof LocalDate) {
                        return ((LocalDate) value).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                    }
                    return null;
                }
            };
        } else {
            return null;
        }
    }
}