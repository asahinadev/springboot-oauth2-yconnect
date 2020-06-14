package com.example.spring.yconnect.dto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.spring.yconnect.dto.ydt.Datum;

import lombok.Data;

@Data
public class GeoCoderRequest {
	enum Ar {
		ge, le, eq
	}

	enum Sort {
		score, dist, kana, rkana, address, address2;

		@Override
		public String toString() {
			switch (this) {
			case rkana:
				return "-kana";

			default:
				return name();

			}
		}
	}

	String query;

	Double lat;
	Double lon;
	String bbox;
	Datum datum = Datum.tky;

	String ac;
	int al = 3;
	Ar ar = Ar.le;
	boolean recursive = true;
	Sort sort = Sort.score;
	int page = 1;
	int results = 10;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		if (StringUtils.isNotEmpty(query)) {
			m.add("query", query);
			m.add("ei", "UTF-8");
			m.add("ac", ac);
			m.add("al", Integer.toString(al));
			m.add("ar", ar.name());
		}

		if (lat != null && lon != null) {
			m.add("lat", Double.toString(lat));
			m.add("lon", Double.toString(lon));
			m.add("datum", datum.name());
		} else if (StringUtils.isNotEmpty(bbox)) {
			m.add("bbox", bbox);
			m.add("datum", datum.name());
		}

		m.add("page", Integer.toString(page));
		m.add("results", Integer.toString(results));
		m.add("sort", sort.toString());

		m.add("output", "json");
		m.add("detail", "standard");

		return m;
	}
}
