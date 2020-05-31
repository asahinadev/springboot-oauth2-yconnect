package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Genre {

	@JsonProperty("Code")
	String code;

	@JsonProperty("Name")
	String name;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
