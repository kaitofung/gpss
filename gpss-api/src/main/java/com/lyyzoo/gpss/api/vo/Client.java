package com.lyyzoo.gpss.api.vo;

import java.util.Date;
public class Client {
	private String cid;
	private String name;
	private String description;
	private String phoneNum;
	private String address;
	private String contacts;
	private Date updatedTime;
	
	@Override
	public String toString() {
		return "Client [cid=" + cid + ", name=" + name + ", description=" + description + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", contacts=" + contacts + ", updatedTime=" + updatedTime + "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
