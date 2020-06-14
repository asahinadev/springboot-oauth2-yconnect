package com.example.spring.yconnect.dto;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.spring.yconnect.converter.StringJoiner;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ZipcodeRequest {

	public enum Area {
		TOWN, BUILDING, CITY, CORPORATION, PRIVATE
	}

	@RequiredArgsConstructor
	public enum Sort {
		ZIP_CODE_ASC("zip_code"),
		ZIP_CODE_DESC("-zip_code"),
		ZIP_KANA_ASC("zip_kana"),
		ZIP_KANA_DESC("-zip_kana");

		final String value;

		@Override
		public String toString() {
			return value;
		}

	}

	String query;
	String ac;
	Area[] zkind;

	int results;
	int start;

	String detail = "standard";
	Sort sort = Sort.ZIP_CODE_ASC;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		if (StringUtils.isNotEmpty(query)) {
			m.add("query", query);
			m.add("ac", ac);
		}

		if (!Objects.isNull(zkind) && zkind.length > 1) {
			m.add("zkind", Arrays.stream(zkind)
					.map(Area::ordinal)
					.collect(new StringJoiner())
					.toString());
		}

		m.add("start", Integer.toString(start));
		m.add("results", Integer.toString(results));
		m.add("output", "json");
		m.add("detail", "standard");
		m.add("sort", sort.toString());

		return m;
	}
}
