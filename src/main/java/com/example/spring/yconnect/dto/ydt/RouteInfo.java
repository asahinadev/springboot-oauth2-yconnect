package com.example.spring.yconnect.dto.ydt;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ルート検索結果の経路詳細情報を含める要素です。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class RouteInfo {

	/** Edge. */
	@JsonProperty("Edge")
	Map<String, Object> edge;

	/** プロパティ. */
	@JsonProperty("Property")
	Map<String, Object> property;
}
