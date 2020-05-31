package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * polygonの内側座標。
 */
@Data
public class Interior {

	/** 経度・緯度情報. */
	@JsonProperty("Coordinates")
	@JsonSerialize(converter = Coordinate.ListSerializer.class)
	@JsonDeserialize(converter = Coordinate.ListDeserializer.class)
	List<Coordinate> coordinates;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();

}
