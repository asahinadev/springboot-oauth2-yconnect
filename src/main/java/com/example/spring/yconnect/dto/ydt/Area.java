package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Area {

	@JsonProperty("Id")
	String id;

	@JsonProperty("Code")
	String code;

	@JsonProperty("Name")
	String name;

	@JsonProperty("Score")
	Double score;

	@JsonProperty("Type")
	Long type;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
