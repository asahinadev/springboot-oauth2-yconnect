package com.example.spring.yconnect.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.yahooapi.config")
public class YahooApiConfig {

	String apikey;

}
