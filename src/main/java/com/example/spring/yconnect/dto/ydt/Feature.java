package com.example.spring.yconnect.dto.ydt;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地図上のアイコンや検索結果リストの1行に表示される拠点情報を表す要素です。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Feature {

	/** 識別子. */
	@JsonProperty("Id")
	String id;

	/** 識別子（店舗）. */
	@JsonProperty("Gid")
	String gid;

	/** 拠点名称. */
	@JsonProperty("Name")
	String name;

	/** カテゴリ. */
	@JsonProperty("Category")
	List<String> categories;

	/** 概要. */
	@JsonProperty("Description")
	String description;

	/** 位置情報. */
	@JsonProperty("Geometry")
	Geometry geometry;

	/** プロパティ. */
	@JsonProperty("Property")
	Property property;

	/** スタイル情報. */
	@JsonProperty("Style")
	List<Map<String, Object>> styles;

	/** 経路情報. */
	@JsonProperty("RouteInfo")
	RouteInfo routeInfo;

}
