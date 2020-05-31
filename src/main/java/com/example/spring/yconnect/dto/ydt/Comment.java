package com.example.spring.yconnect.dto.ydt;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Comment {

	@JsonProperty("Id")
	String Id;

	@JsonProperty("Subject")
	String subject;

	@JsonProperty("Body")
	String body;

	@JsonProperty("Guid")
	String guid;

	@JsonProperty("Author")
	String author;

	@JsonProperty("Rating")
	Long rating;

	@JsonProperty("VisitDate")
	String visitDate;

	@JsonProperty("Scene")
	String scene;

	@JsonProperty("UsefulCount")
	Long usefulCount;

	@JsonProperty("LinkUrl")
	URL linkUrl;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
