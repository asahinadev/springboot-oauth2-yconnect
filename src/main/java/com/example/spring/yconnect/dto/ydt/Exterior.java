package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * polygonの外側座標。
 */
@Data
public class Exterior {

	/** 経度・緯度情報. */
	@JsonProperty("Coordinates")
	String coordinates;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();

}
