package com.wzq.tacos.repository;

import com.wzq.tacos.model.Ingredient;

/**
 * @author ziqian.wang
 * @date 2022/3/10 15:38
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
