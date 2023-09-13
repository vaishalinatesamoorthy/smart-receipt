package com.example.receipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan
public class SmartReceiptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartReceiptApplication.class, args);
	}

}
