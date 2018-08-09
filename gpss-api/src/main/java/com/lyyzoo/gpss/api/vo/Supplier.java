package com.lyyzoo.gpss.api.vo;

import java.util.Date;

public class Supplier {
	private String sid;
	private String name;
	private String mobile;
	private String contacts_name;
	private String address;
	private String description;
	private Date updatetime;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContacts_name() {
		return contacts_name;
	}
	public void setContacts_name(String contacts_name) {
		this.contacts_name = contacts_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", name=" + name + ", mobile=" + mobile + ", contacts_name=" + contacts_name
				+ ", address=" + address + ", description=" + description + ", updatetime=" + updatetime + "]";
	}

}
