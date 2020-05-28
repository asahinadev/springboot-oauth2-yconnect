package com.example.spring.yconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfig {

	protected static final String API = "https://map.yahooapis.jp/";

	@Bean
	public WebClient yahooapis(
			@Autowired YahooApiConfig config,
			ReactiveClientRegistrationRepository clientRegistrationRepo,
			ServerOAuth2AuthorizedClientRepository authorizedClientRepo) {

		ServerOAuth2AuthorizedClientExchangeFilterFunction filter;
		filter = new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepo, authorizedClientRepo);

		return WebClient.builder()
				.baseUrl(API)
				.defaultHeader("User-Agent", "Yahoo AppID: " + config.getApikey())
				.filter(filter)
				.build();
	}

}
