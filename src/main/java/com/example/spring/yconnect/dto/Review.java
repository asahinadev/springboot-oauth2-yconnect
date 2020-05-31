package com.example.spring.yconnect.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.Data;

@Data
public class Review {

	int results = 10;
	int start = 1;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		m.add("start", Integer.toString(start));
		m.add("results", Integer.toString(results));
		m.add("output", "json");

		return m;
	}
}
