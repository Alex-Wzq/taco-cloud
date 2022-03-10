package com.wzq.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        // 创建Spring 应用程序上下文。传递给 run() 方法的两个参数是一个配置类和命令行参数
        SpringApplication.run(TacoCloudApplication.class, args);
    }

}
