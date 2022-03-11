package com.wzq.tacos.converter;

import com.wzq.tacos.model.Ingredient;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author ziqian.wang
 * @date 2022/3/11 13:08
 */
// 全局生效
@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Ingredient.Type, String> {

    @Override
    public String convertToDatabaseColumn(Ingredient.Type type) {
        return type.toString();
    }

    @Override
    public Ingredient.Type convertToEntityAttribute(String s) {
        return Ingredient.Type.valueOf(s);
    }
}
