package com.example.spring.yconnect.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.spring.yconnect.validation.AddressCode;

import lombok.Data;

@Data
public class AddressDirectoryRequest {

	@AddressCode
	String ac;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();
		m.add("ac", ac);
		m.add("output", "json");
		m.add("mode", "2");

		return m;
	}
}
