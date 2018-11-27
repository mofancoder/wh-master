package com.mofan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.mofan.*"})
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.mofan.dao.*")
public class WhWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhWebApplication.class, args);
    }
}
