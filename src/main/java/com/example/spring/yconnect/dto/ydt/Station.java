package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Station {

	@JsonProperty("Id")
	String id;

	@JsonProperty("SubId")
	String subId;

	@JsonProperty("Name")
	String name;

	@JsonProperty("Railway")
	String railway;

	@JsonProperty("Exit")
	String exit;

	@JsonProperty("ExitId")
	String exitId;

	@JsonProperty("Distance")
	String distance;

	@JsonProperty("Time")
	String time;

	@JsonProperty("Geometry")
	Geometry geometry;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
