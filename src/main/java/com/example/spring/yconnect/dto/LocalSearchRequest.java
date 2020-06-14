package com.example.spring.yconnect.dto;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.spring.yconnect.dto.ydt.Datum;

import lombok.Data;

@Data
public class LocalSearchRequest {

	enum Sort {
		string,
		rating,
		score,
		hybrid,
		review,
		kana,
		price,
		dist,
		geo,
		match;

		@Override
		public String toString() {
			return name();
		}
	}

	String device;
	String query;
	String id;
	String cid;
	String uid;
	String gid;
	String bid;
	String group;
	boolean distinct = true;
	Double lat;
	Double lon;
	String bbox;
	Double dist;
	Datum datum = Datum.tky;
	String ac;
	String gc;
	boolean coupon = false;
	boolean parking = false;
	boolean creditcard = false;
	String smoking;
	boolean reservation = false;
	boolean image = false;
	String open;
	boolean locoMode = true;
	Long minprice;
	Long maxprice;
	Sort sort = Sort.score;
	int page = 1;
	int results = 10;

	public MultiValueMap<String, String> parameters() {

		MultiValueMap<String, String> m = new LinkedMultiValueMap<>();

		if (StringUtils.equals(device, "mobile")) {
			m.add("device", device);
		}

		if (StringUtils.isNotEmpty(id)) {
			m.add("id", id);
		}
		if (StringUtils.isNotEmpty(cid)) {
			m.add("cid", cid);
		}
		if (StringUtils.isNotEmpty(gid)) {
			m.add("gid", gid);
		}
		if (StringUtils.isNotEmpty(uid)) {
			m.add("uid", uid);
		}
		if (StringUtils.isNotEmpty(bid)) {
			m.add("bid", gid);
		}
		if (StringUtils.isNotEmpty(group)) {
			m.add("group", group);
		}
		m.add("distinct", Boolean.toString(distinct));
		if (StringUtils.isNotEmpty(query)) {
			m.add("query", query);
			m.add("ei", "UTF-8");
			m.add("ac", ac);
		}
		if (!Objects.isNull(lat) && !Objects.isNull(lon)) {
			m.add("lat", Double.toString(lat));
			m.add("lon", Double.toString(lon));
			m.add("datum", datum.name());
			if (!Objects.isNull(dist)) {
				m.add("dist", Double.toString(dist));
			}
		} else if (StringUtils.isNotEmpty(bbox)) {
			m.add("bbox", bbox);
			m.add("datum", datum.name());
		}
		if (StringUtils.isNotEmpty(ac)) {
			m.add("ac", ac);
		}
		if (StringUtils.isNotEmpty(gc)) {
			m.add("gc", gc);
		}
		m.add("coupon", Boolean.toString(coupon));
		m.add("parking", Boolean.toString(parking));
		m.add("creditcard", Boolean.toString(creditcard));
		if (StringUtils.isNotEmpty(smoking)) {
			m.add("smoking", smoking);
		}
		m.add("reservation", Boolean.toString(reservation));
		m.add("image", Boolean.toString(image));
		if (StringUtils.isNotEmpty(open)) {
			m.add("open", open);
		}
		m.add("loco_mode", String.valueOf(locoMode));
		if (!Objects.isNull(minprice)) {
			m.add("minprice", String.valueOf(minprice));
		}
		if (!Objects.isNull(maxprice)) {
			m.add("maxprice", String.valueOf(maxprice));
		}

		m.add("page", Integer.toString(page));
		m.add("results", Integer.toString(results));
		m.add("sort", sort.toString());

		m.add("output", "json");
		m.add("detail", "standard");

		return m;
	}

}
