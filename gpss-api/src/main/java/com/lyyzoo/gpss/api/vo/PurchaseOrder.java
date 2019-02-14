package com.lyyzoo.gpss.api.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PurchaseOrder {
	@Setter
	@Getter
	private String poid;
	@Setter
	@Getter
	private String purchaseOrderGid;
	@Setter
	@Getter
	private String gname;
	@Setter
	@Getter
	private String purchaseOrderGspecificationId;
	@Setter
	@Getter
	private String gsname;
	@Setter
	@Getter
	private String purchaseOrderStoreId;
	@Setter
	@Getter
	private String storageName;
	@Setter
	@Getter
	private String storageId;
	@Setter
	@Getter
	private String supplierId;
	@Setter
	@Getter
	private String supplierName;
	@Setter
	@Getter
	private String appendix;
	@Setter
	@Getter
	private int num;
	@Setter
	@Getter
	private float price;
	@Setter
	@Getter
	private float sum;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String auditStatus;
	private Date createdtime;
	@Setter
	@Getter
	private String createrId;
	@Setter
	@Getter
	private String createrName;
	@Setter
	@Getter
	private String auditedId;
	@Setter
	@Getter
	private Date auditedTime;
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	
	
	
}
