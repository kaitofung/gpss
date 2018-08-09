package com.lyyzoo.gpss.api.vo;

public class Storage {
	private String name;
	private String address;
	private String mobile;
	private String description;
	private String ename;
	private String sid;
	private String eid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Storage [name=" + name + ", address=" + address + ", mobile=" + mobile + ", description=" + description
				+ ", ename=" + ename + ", sid=" + sid + "eid=" + eid + "]";
	}
	
}
