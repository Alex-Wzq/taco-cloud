package com.wzq.tacos.repository;

import com.wzq.tacos.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ziqian.wang
 * @date 2022/3/11 15:58
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
