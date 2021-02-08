package com.gd.model.entity.converter;

import com.gd.model.entity.Availability;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AvailabilityConverter implements AttributeConverter<Availability, String> {

    @Override
    public String convertToDatabaseColumn(Availability availability) {
        return availability.name();
    }

    @Override
    public Availability convertToEntityAttribute(String availability) {
        return Availability.valueOf(availability);
    }
}
