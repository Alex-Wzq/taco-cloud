package com.wzq.tacos.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzq.tacos.model.Order;
import com.wzq.tacos.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziqian.wang
 * @date 2022/3/10 19:59
 */
@Repository
public class JdbcOrderRepository {

    private SimpleJdbcInsert orderInserter;

    private SimpleJdbcInsert orderTacoInserter;

    // object -> map
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id"); //  id 属性将由数据库提供或生成

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();
    }
    
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);

        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos) {
            saveTacoToOrder(taco, orderId);
        }

        return order;
    }

    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values = objectMapper.convertValue(order, Map.class);

        // ObjectMapper 会将 Date 属性转换为 long
        values.put("placedAt", order.getPlacedAt());

        long orderId = orderInserter.executeAndReturnKey(values).longValue();

        return orderId;
    }

    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());

        orderTacoInserter.execute(values);
    }

}
