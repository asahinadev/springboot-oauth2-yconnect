package com.example.spring.yconnect.dto.ydt;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * YDF ルート情報。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Ydf {

	@JsonProperty("ResultInfo")
	ResultInfo resultInfo;

	@JsonProperty("Feature")
	Feature[] features;

	@JsonProperty("Dictionary")
	Map<String, Object> dictionary;

	@JsonProperty("Error")
	Map<String, Object> error;

}
