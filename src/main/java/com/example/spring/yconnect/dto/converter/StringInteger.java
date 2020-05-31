package com.example.spring.yconnect.dto.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class StringInteger {

	public static class Serializer extends StdConverter<Integer, String> {

		@Override
		public String convert(Integer value) {
			return String.valueOf(value);
		}

	}

	public static class Deserializer extends StdConverter<String, Integer> {

		@Override
		public Integer convert(String value) {
			return Integer.valueOf(value);
		}
	}
}
