package com.example.spring.yconnect.dto.ydt;

import com.fasterxml.jackson.databind.util.StdConverter;

/**
 * 図形種別。
 */
public enum Type {
	point,
	linestring,
	polygon,
	circle,
	ellipse,
	multigeometry;

	public static class Serializer extends StdConverter<Type, String> {

		@Override
		public String convert(Type value) {
			return value.name();
		}

	}

	public static class Deserializer extends StdConverter<String, Type> {

		@Override
		public Type convert(String value) {
			return Enum.valueOf(Type.class, value);
		}
	}

}
