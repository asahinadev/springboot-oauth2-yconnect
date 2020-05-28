package com.example.spring.yconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/")
public class IndexController {

	final WebClient yahooapis;

	public IndexController(WebClient yahooapis) {
		this.yahooapis = yahooapis;
	}

	@GetMapping
	public String index() {
		return "index";
	}
}
