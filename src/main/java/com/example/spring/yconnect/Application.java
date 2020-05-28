package com.example.spring.yconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(basePackages = {
		"com.example.spring.yconnect.config"
})
@SpringBootApplication(scanBasePackages = {
		"com.example.spring.yconnect"
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
