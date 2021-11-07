package com.bistu.threeday;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bistu.threeday.player.mapper")
public class ThreeDayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreeDayApplication.class, args);
    }

}
