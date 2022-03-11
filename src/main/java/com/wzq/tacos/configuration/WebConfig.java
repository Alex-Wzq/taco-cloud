package com.wzq.tacos.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ziqian.wang
 * @date 2022/3/10 14:17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 一个只将请求转发给视图的控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 视图控制器处理 GET 请求的路径
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

}
