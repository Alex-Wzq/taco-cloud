package com.wzq.tacos.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ziqian.wang
 * @date 2022/3/9 14:06
 */

@Data
@RequiredArgsConstructor
// JPA 要求实体有一个无参构造函数, 。但是要是不希望使用它，可以通过将 access 属性设置为 AccessLevel.PRIVATE 来将其设置为私有
// 因为必须设置 final 属性，所以还要将 force 属性设置为 true，这将导致 Lombok 生成的构造函数将它们设置为 null。
@NoArgsConstructor(force = true)
// 为了将其声明为 JPA 实体，必须使用 @Entity 注解
@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @Column(name = "id")
    private final String id;

    @Column(name = "name")
    private final String name;

    @Column(name = "type")
    private final Type type;

    @Getter
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