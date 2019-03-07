package com.lyyzoo.gpss.api.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class StorageRecord {

	@Setter
	@Getter
	private String srid;
	@Setter
	@Getter
	private String gname;
	@Setter
	@Getter
	private String gspecificationName;
	@Setter
	@Getter
	private String gspecificationId;
	@Setter
	@Getter
	private String storageName;
	@Setter
	@Getter
	private String storageId;
	@Setter
	@Getter
	private int storageCount;
	@Setter
	@Getter
	private int salesCount;
	@Setter
	@Getter
	private float lastPrice;
	@Setter
	@Getter
	private float avgPurchasePrice;
	@Setter
	@Getter
	private float preditedPrice;
	@Setter
	@Getter
	private float storageSumValue;
	@Setter
	@Getter
	private float salesSumValue;
	
}
