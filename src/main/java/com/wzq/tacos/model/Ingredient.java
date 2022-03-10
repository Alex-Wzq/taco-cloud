package com.wzq.tacos.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author ziqian.wang
 * @date 2022/3/9 14:06
 */

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    @RequiredArgsConstructor
    public static enum Type {

        WRAP("包"),

        PROTEIN("蛋白质"),

        VEGGIES("蔬菜"),

        CHEESE("干酪"),

        SAUCE("酱");

        private final String desc;
    }
}