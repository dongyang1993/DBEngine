package com.example.dbengin.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class IntegerToBooleanConverter implements Converter<Integer, Boolean> {

    @Override
    public Boolean convert(Integer integer) {
        if (integer > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
