package com.wzq.tacos.repository;

import com.wzq.tacos.model.Ingredient;
import com.wzq.tacos.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;


/**
 * @author ziqian.wang
 * @date 2022/3/10 19:20
 */
@Repository
public class JdbcTacoRepository {

    @Autowired
    private JdbcTemplate jdbc;
    
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        // 创建 PreparedStatementCreator 非常重要。首先创建一个 PreparedStatementCreatorFactory，为它提供想要执行的 SQL，
        // 以及每个查询参数的类型。然后在该工厂上调用 newPreparedStatementCreator()，
        // 在查询参数中传递所需的值以生成 PreparedStatementCreator。
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        ).newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime())));

        // KeyHolder 将提供生成的 Taco id
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update(
                "insert into Taco_Ingredients (taco, ingredient) " + "values (?, ?)",
                tacoId, ingredient);
    }
}
