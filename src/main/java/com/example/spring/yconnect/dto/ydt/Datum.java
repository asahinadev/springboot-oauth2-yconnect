package com.example.spring.yconnect.dto.ydt;

import com.fasterxml.jackson.databind.util.StdConverter;

/**
 * 座標測地系。
 */
public enum Datum {
	wgs, tky;

	public static class Serializer extends StdConverter<Datum, String> {

		@Override
		public String convert(Datum value) {
			return value.name();
		}

	}

	public static class Deserializer extends StdConverter<String, Datum> {

		@Override
		public Datum convert(String value) {
			return Enum.valueOf(Datum.class, value);
		}
	}

}
