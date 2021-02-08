package com.gd.model.entity.converter;

import com.gd.model.entity.Education;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EducationConverter implements AttributeConverter<Education, String> {

    @Override
    public String convertToDatabaseColumn(Education education) {
        return education.name();
    }

    @Override
    public Education convertToEntityAttribute(String education) {
        return Education.valueOf(education);
    }
}
