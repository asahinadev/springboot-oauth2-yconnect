package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResultSet {

	@JsonProperty("Address")
	List<String> address;

	@JsonProperty("Roadname")
	String roadname;

	@JsonProperty("Country")
	Country country;

	@JsonProperty("Area")
	List<Area> areas;

	@JsonProperty("Result")
	List<Result> results;

	@JsonProperty("Govcode")
	String govcode;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
