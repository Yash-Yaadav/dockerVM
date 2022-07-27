package com.yash.microservices.labs.moneyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoneyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyConversionServiceApplication.class, args);
	}

}
