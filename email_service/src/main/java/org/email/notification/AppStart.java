package org.email.notification;
/*
 * @Author Debu Paul
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppStart {
	
	public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

}
