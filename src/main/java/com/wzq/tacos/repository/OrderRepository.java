package com.wzq.tacos.repository;

import com.wzq.tacos.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ziqian.wang
 * @date 2022/3/10 19:19
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

//    Order save(Order order);

//    @Query(value = "select * from Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersDeliveredInSeattle();

}
