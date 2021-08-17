package com.restapi.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication()
@EnableFeignClients
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
