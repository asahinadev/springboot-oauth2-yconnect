package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * ルート検索結果の経路詳細情報を含める要素です。
 */
@Data
public class RouteInfo {

	/** Edge. */
	@JsonProperty("Edge")
	Map<String, Object> edge;

	/** プロパティ. */
	@JsonProperty("Property")
	Property property;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();
}
