package com.wzq.tacos.repository;

import com.wzq.tacos.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ziqian.wang
 * @date 2022/3/10 15:38
 */
// CrudRepository : 一个参数是存储库要持久化的实体类型，第二个参数是实体 id 属性的类型
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//    Iterable<Ingredient> findAll();
//
//    Ingredient findOne(String id);
//
//    Ingredient save(Ingredient ingredient);

}
