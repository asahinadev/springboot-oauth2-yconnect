package com.example.spring.yconnect.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.Data;

@Data
public class LatLong {

	double lat;
	double lon;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		m.add("lat", Double.toString(lat));
		m.add("lon", Double.toString(lon));
		m.add("output", "json");

		return m;
	}
}
