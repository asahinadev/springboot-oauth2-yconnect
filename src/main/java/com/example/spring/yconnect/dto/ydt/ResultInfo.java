package com.example.spring.yconnect.dto.ydt;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * YDFデータのレスポンス情報全体に関する情報を設定する要素です。
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResultInfo {

	/** データ件数. */
	@JsonProperty("Count")
	float count;

	/** 総データ件数. */
	@JsonProperty("Total")
	long total;

	/** 取得開始件数. */
	@JsonProperty("Start")
	long start;

	/** 処理時間. */
	@JsonProperty("Latency")
	long latency;

	/** ステータスコード. */
	@JsonProperty("Status")
	long status;

	/** 概要. */
	@JsonProperty("Description")
	String description;

	/** 著作権表示. */
	@JsonProperty("Copyright")
	String copyright;

	@JsonProperty("CompressType")
	String compressType;

	@JsonAnySetter
	Map<String, Object> any = new HashMap<>();

}