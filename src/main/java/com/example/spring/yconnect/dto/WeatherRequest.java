package com.example.spring.yconnect.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.Data;

@Data
public class WeatherRequest {

	String coordinates;
	Double lat;
	Double lon;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime date;
	int past = 0;
	int interval = 10;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		if (lat != null && lon != null) {
			m.add("coordinates", Double.toString(lon) + "," + Double.toString(lat));
		} else {
			m.add("coordinates", coordinates);
		}

		if (Objects.isNull(date)) {
			m.add("date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
		} else {
			m.add("date", date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
		}

		m.add("past", Integer.toString(past));
		m.add("interval", Integer.toString(interval));

		m.add("output", "json");
		m.add("detail", "standard");

		return m;
	}
}
