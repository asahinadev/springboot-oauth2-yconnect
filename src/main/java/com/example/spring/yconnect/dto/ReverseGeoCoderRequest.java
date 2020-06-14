package com.example.spring.yconnect.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.spring.yconnect.dto.ydt.Datum;

import lombok.Data;

@Data
public class ReverseGeoCoderRequest {

	double lat;
	double lon;
	Datum datum = Datum.tky;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		m.add("lat", Double.toString(lat));
		m.add("lon", Double.toString(lon));
		m.add("datum", datum.name());
		m.add("output", "json");

		return m;
	}
}
