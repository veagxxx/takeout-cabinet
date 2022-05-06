package com.zhy.takeoutcabinet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhy.takeoutcabinet.mapper")
public class TakeoutCabinetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeoutCabinetApplication.class, args);
    }

}
