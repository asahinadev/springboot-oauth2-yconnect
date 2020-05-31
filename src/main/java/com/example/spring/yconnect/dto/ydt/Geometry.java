package com.example.spring.yconnect.dto.ydt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 拠点の場所を表す要素です。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Geometry {

	/** 識別子. */
	@JsonProperty("Id")
	String id;

	/** 識別子（位置情報）. */
	@JsonProperty("Target")
	private String target;

	/** 図形種別. */
	@JsonProperty("Type")
	@JsonSerialize(converter = Type.Serializer.class)
	@JsonDeserialize(converter = Type.Deserializer.class)
	Type type;

	/** 経度・緯度情報. */
	@JsonProperty("Coordinates")
	@JsonSerialize(converter = Coordinate.ListSerializer.class)
	@JsonDeserialize(converter = Coordinate.ListDeserializer.class)
	List<Coordinate> coordinates;

	/** 表示範囲. */
	@JsonProperty("BoundingBox")
	Object boundingBox;

	/** 表示範囲. */
	@JsonProperty("Compress")
	Object compress;

	/** 表示範囲. */
	@JsonProperty("CompressType")
	Object compressType;

	/** 座標測地系. */
	@JsonProperty("Datum")
	@JsonSerialize(converter = Datum.Serializer.class)
	@JsonDeserialize(converter = Datum.Deserializer.class)
	Datum datum;

	/** polygonの外側座標. */
	@JsonProperty("Exterior")
	Exterior exterior;

	/** polygonの内側座標. */
	@JsonProperty("Interior")
	Interior interior;

	/** 半径. */
	@JsonProperty("Radius")
	String radius;

	/** 測地系の有無. */
	@JsonProperty("GeodesicFlag")
	String geodesicFlag;

	/** 距離(キロメートル). */
	@JsonProperty("Distance")
	String Distance;

}