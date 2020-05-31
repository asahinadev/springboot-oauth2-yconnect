package com.example.spring.yconnect.dto.ydt;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * YDF ルート情報。
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Ydf {

	@JsonProperty("ResultInfo")
	ResultInfo resultInfo;

	@JsonProperty("Feature")
	Feature[] features;

	@JsonProperty("Dictionary")
	Map<String, Object> dictionary;

	@JsonProperty("ResultSet")
	ResultSet resultSet;

	@JsonProperty("Error")
	Map<String, Object> error;

	@JsonAnySetter
	Map<String, Object> any;

}
