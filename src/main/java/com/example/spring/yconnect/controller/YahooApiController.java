package com.example.spring.yconnect.controller;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.spring.yconnect.config.YahooApiConfig;
import com.example.spring.yconnect.dto.GeoCoder;
import com.example.spring.yconnect.dto.LocalSearch;
import com.example.spring.yconnect.dto.ReverseGeoCoder;
import com.example.spring.yconnect.dto.ydt.Ydf;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequestMapping("/yahooapis")
public class YahooApiController {

	protected Consumer<Map<String, Object>> attributes(OAuth2AuthorizedClient client) {
		return ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client);
	}

	final WebClient yahooapis;

	final YahooApiConfig config;

	public YahooApiController(WebClient yahooapis, YahooApiConfig config) {
		this.yahooapis = yahooapis;
		this.config = config;
	}

	@ResponseBody
	@GetMapping("local-search")
	public Mono<Ydf> localSearch(LocalSearch params) {
		log.debug("{}", params);
		return yahooapis.get()
				.uri(b -> b.path("search/local/V1/localSearch")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping("geocoder")
	public Mono<Ydf> geocoder(GeoCoder params) {
		log.debug("{}", params);
		return yahooapis.get()
				.uri(b -> b.path("geocode/V1/geoCoder")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "reverse-geocoder", params = { "lon", "lat" })
	public Mono<Ydf> reverseGeocoder(ReverseGeoCoder params) {
		log.debug("{}", params);
		return yahooapis.get()
				.uri(b -> b.path("geoapi/V1/reverseGeoCoder")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

}
