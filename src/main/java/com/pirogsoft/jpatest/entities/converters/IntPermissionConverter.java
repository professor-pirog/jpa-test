package com.pirogsoft.jpatest.entities.converters;

import com.pirogsoft.jpatest.entities.Permission;
import javafx.util.Builder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class IntPermissionConverter implements AttributeConverter<Permission, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Permission attribute) {
        int ri = attribute.isRead() ? 4 : 0;
        int wi = attribute.isWrite() ? 2 : 0;
        int di = attribute.isDelete() ? 1 : 0;
        return ri + wi + di;
    }

    @Override
    public Permission convertToEntityAttribute(Integer dbData) {
        boolean isRead = dbData > 3;
        boolean isWrite = dbData % 4 > 1;
        boolean isDelete = dbData % 2 > 0;
        return new Permission(isRead, isWrite, isDelete);
    }
}
