package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result {

	@JsonProperty("Uid")
	String uid;

	@JsonProperty("Name")
	String name;

	@JsonProperty("Score")
	Double score;

	@JsonProperty("Category")
	String category;

	@JsonProperty("Label")
	String label;

	@JsonProperty("Combined")
	String combined;

	@JsonProperty("Where")
	String where;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
