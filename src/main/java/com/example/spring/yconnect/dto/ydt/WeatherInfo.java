package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WeatherInfo {

	@JsonProperty("Type")
	String type;

	@JsonProperty("Date")
	String date;

	@JsonProperty("Rainfall")
	Double rainfall;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
