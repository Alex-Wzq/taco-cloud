package com.wzq.tacos.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author ziqian.wang
 * @date 2022/3/9 14:35
 */
@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    // 它将 createdAt 属性设置为保存 Taco 之前的当前日期和时间
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
