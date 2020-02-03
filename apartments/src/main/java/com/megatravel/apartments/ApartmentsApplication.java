package com.megatravel.apartments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentsApplication.class, args);
	}

}
