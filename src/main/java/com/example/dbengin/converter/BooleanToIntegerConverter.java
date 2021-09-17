package com.example.dbengin.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class BooleanToIntegerConverter implements Converter<Boolean, Integer> {

    @Override
    public Integer convert(Boolean bool) {
        return bool ? 1 : 0;
    }
}
