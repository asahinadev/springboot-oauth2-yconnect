package com.example.spring.yconnect.dto.ydt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * polygonの内側座標。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Interior {

	/** 経度・緯度情報. */
	@JsonProperty("Coordinates")
	@JsonSerialize(converter = Coordinate.ListSerializer.class)
	@JsonDeserialize(converter = Coordinate.ListDeserializer.class)
	List<Coordinate> coordinates;

}
