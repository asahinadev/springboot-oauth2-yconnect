package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.yconnect.dto.converter.StringBoolean;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * プロパティ情報。
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Property {

	@JsonProperty("Uid")
	String uid;

	@JsonProperty("CassetteId")
	String cassetteId;

	@JsonProperty("SmartPhoneCouponFlag")
	@JsonSerialize(converter = StringBoolean.Serializer.class)
	@JsonDeserialize(converter = StringBoolean.Deserializer.class)
	boolean smartPhoneCouponFlag;

	@JsonProperty("Address")
	String address;

	@JsonProperty("AddressMatchingLevel")
	String addressMatchingLevel;

	@JsonProperty("AddressType")
	String addressType;

	@JsonProperty("GovernmentCode")
	String governmentCode;

	@JsonProperty("CatchCopy")
	String catchCopy;

	@JsonProperty("Station")
	List<Station> stations;

	@JsonProperty("Area")
	List<Area> areas;

	@JsonProperty("Country")
	Country country;

	@JsonProperty("Yomi")
	String yomi;

	@JsonProperty("Genre")
	List<Genre> genres;

	@JsonProperty("Rating")
	String rating;

	@JsonProperty("PlaceInfo")
	PlaceInfo placeInfo;

	@JsonProperty("WeatherAreaCode")
	String weatherAreaCode;

	@JsonProperty("WeatherList")
	WeatherList weatherList;

	@JsonProperty("PostalName")
	String postalName;

	@JsonProperty("Comment")
	Comment comment;

	@JsonProperty("CreateDate")
	String createDate;

	@JsonProperty("UpdateDate")
	String updateDate;

	Map<String, String> values = new HashMap<>();

	Map<String, Object> any = new HashMap<>();

	@JsonAnySetter
	public void setAny(String key, Object value) {
		if (key.matches("^Access[\\d]+$")
				|| key.matches("^Tel[\\d]+$")) {
			values.put(key, String.valueOf(value));
		} else {
			any.put(key, value);
		}
	}

	@JsonAnyGetter
	public Map<String, String> getValues() {
		return values;
	}

}
