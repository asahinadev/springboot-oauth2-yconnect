package com.example.spring.yconnect.dto.ydt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.util.StdConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 経度,緯度情報。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Coordinate {

	/** 緯度. */
	double lat;
	/** 経度. */
	double lng;

	public String toJsonValue() {
		return String.format("%8.5f,%8.5f", lng, lat);
	}

	public static class Serializer extends StdConverter<Coordinate, String> {

		@Override
		public String convert(Coordinate value) {
			return value.toJsonValue();
		}

	}

	public static class ListSerializer extends StdConverter<List<Coordinate>, String> {

		@Override
		public String convert(List<Coordinate> values) {
			Serializer serializer = new Serializer();
			return values.stream().map(serializer::convert)
					.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
					.toString();
		}

	}

	public static class Deserializer extends StdConverter<String, Coordinate> {

		@Override
		public Coordinate convert(String value) {
			String[] values = value.split(",");
			return Coordinate.builder()
					.lng(Double.valueOf(values[0]))
					.lat(Double.valueOf(values[1]))
					.build();
		}
	}

	public static class ListDeserializer extends StdConverter<String, List<Coordinate>> {

		@Override
		public List<Coordinate> convert(String value) {
			Deserializer deserializer = new Deserializer();
			return Arrays.stream(value.split(new String(new char[] { 0x20 })))
					.map(deserializer::convert)
					.collect(Collectors.toList());
		}
	}
}
