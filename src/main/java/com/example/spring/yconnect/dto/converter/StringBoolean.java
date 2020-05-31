package com.example.spring.yconnect.dto.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class StringBoolean {

	public static class Serializer extends StdConverter<Boolean, String> {

		@Override
		public String convert(Boolean value) {
			return String.valueOf(value);
		}

	}

	public static class Deserializer extends StdConverter<String, Boolean> {

		@Override
		public Boolean convert(String value) {
			return Boolean.valueOf(value);
		}
	}
}
