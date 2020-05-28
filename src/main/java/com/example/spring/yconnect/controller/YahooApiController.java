package com.example.spring.yconnect.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.spring.yconnect.config.YahooApiConfig;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/yahooapis")
public class YahooApiController {

	private class MapTypeReference extends ParameterizedTypeReference<Map<String, Object>> {

	}

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
	public Mono<Map<String, Object>> localSearch(@RequestParam MultiValueMap<String, String> params) {

		MultiValueMap<String, String> _params = new LinkedMultiValueMap<>(params);
		_params.put("output", Arrays.asList("json"));

		return yahooapis.get()
				.uri(b -> b.path("search/local/V1/localSearch").queryParams(_params).build()).retrieve()
				.bodyToMono(new MapTypeReference());
	}

	@ResponseBody
	@GetMapping("geocoder")
	public Mono<Map<String, Object>> geocode(@RequestParam MultiValueMap<String, String> params) {

		MultiValueMap<String, String> _params = new LinkedMultiValueMap<>(params);
		_params.put("output", Arrays.asList("json"));

		return yahooapis.get()
				.uri(b -> b.path("geocode/V1/geoCoder").queryParams(_params).build()).retrieve()
				.bodyToMono(new MapTypeReference());
	}

}
