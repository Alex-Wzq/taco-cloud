package com.wzq.tacos.repository;

import com.wzq.tacos.model.Order;

/**
 * @author ziqian.wang
 * @date 2022/3/10 19:19
 */
public interface OrderRepository {

    Order save(Order order);
}
