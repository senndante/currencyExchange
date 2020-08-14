package com.arw.currencyconverter.mappers;

import com.arw.currencyconverter.dto.ConversionDto;
import com.arw.currencyconverter.entities.Conversion;

public class ConversionDtoMapper {
    private ConversionDtoMapper() {}

    public static ConversionDto getMapping(Conversion conversion) {
        ConversionDto result = new ConversionDto();

        result.setCurrencyFromCode(conversion.getCurrencyFrom().getNumCode());
        result.setCurrencyToCode(conversion.getCurrencyTo().getNumCode());
        result.setAmount(conversion.getAmount());
        result.setResult(conversion.getResult());
        result.setDate(conversion.getDate());

        return result;
    }
}
