package com.programming.techie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication

public class PMServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PMServiceApplication.class, args);
    }


}
