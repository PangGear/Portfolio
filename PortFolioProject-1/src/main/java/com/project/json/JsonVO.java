package com.project.json;

import lombok.Data;

@Data
public class JsonVO {

	private String idx;
	
	private String facility;
	private String roadAddress;
	private String latitude;
	private String longitude;
	private String telephone;
	private String facilityInfo;
	private String facilityFeature;
	
	private String homepage;
	private String facilElectric;
	private String facilHotwater;
	private String facilWifi;
	private String facilFirewood;
	private String facilMarket;
	
	private String ch1;
	private String ch2;
	
	private int pageSize;
	private int start;
	private int totalCount;
}
