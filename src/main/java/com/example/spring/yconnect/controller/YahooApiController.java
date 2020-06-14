package com.example.spring.yconnect.controller;

import java.util.Map;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.spring.yconnect.config.YahooApiConfig;
import com.example.spring.yconnect.dto.AddressDirectoryRequest;
import com.example.spring.yconnect.dto.GeoCoderRequest;
import com.example.spring.yconnect.dto.LocalSearchRequest;
import com.example.spring.yconnect.dto.PlaceInfoRequest;
import com.example.spring.yconnect.dto.ReverseGeoCoderRequest;
import com.example.spring.yconnect.dto.ReviewRequest;
import com.example.spring.yconnect.dto.WeatherRequest;
import com.example.spring.yconnect.dto.ZipcodeRequest;
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
	public Mono<Ydf> localSearch(LocalSearchRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("search/local/V1/localSearch")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping("geocoder")
	public Mono<Ydf> geocoder(GeoCoderRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("geocode/V1/geoCoder")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "reverse-geocoder", params = { "lon", "lat" })
	public Mono<Ydf> reverseGeocoder(ReverseGeoCoderRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("geoapi/V1/reverseGeoCoder")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "weather")
	public Mono<Ydf> weather(WeatherRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("weather/V1/place")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "zipcode")
	public Mono<Ydf> zipcode(ZipcodeRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("search/zip/V1/zipCodeSearch")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "review/{uid}")
	public Mono<Ydf> review(ReviewRequest params, @PathVariable("uid") String uid) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("olp/v1/review/{uid}")
						.queryParams(params.parameters()).build(uid))
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "placeinfo", params = { "lon", "lat" })
	public Mono<Ydf> placeinfo(PlaceInfoRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("placeinfo/V1/get")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ResponseBody
	@GetMapping(path = "address", params = { "ac" })
	public Mono<Ydf> address(@Valid AddressDirectoryRequest params) {
		log.debug("{} => {}", params, params.parameters());
		return yahooapis.get()
				.uri(b -> b.path("search/address/V1/addressDirectory")
						.queryParams(params.parameters()).build())
				.retrieve()
				.bodyToMono(Ydf.class);
	}

	@ExceptionHandler(WebExchangeBindException.class)
	public ResponseEntity<?> exception(WebExchangeBindException e) {
		return new ResponseEntity<>(
				Map.of(
						"status_code", HttpStatus.BAD_REQUEST,
						e.getFieldError().getField(), e.getFieldError().getRejectedValue()),
				HttpStatus.BAD_REQUEST);
	}

}
