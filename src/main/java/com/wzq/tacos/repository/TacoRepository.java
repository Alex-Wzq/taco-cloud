package com.wzq.tacos.repository;

import com.wzq.tacos.model.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ziqian.wang
 * @date 2022/3/10 19:19
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {

}
