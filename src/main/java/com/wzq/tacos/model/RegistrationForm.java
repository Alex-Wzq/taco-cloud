package com.wzq.tacos.model;


import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ziqian.wang
 * @date 2022/3/11 16:29
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
    }
}