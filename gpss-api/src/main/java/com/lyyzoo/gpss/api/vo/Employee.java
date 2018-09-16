package com.lyyzoo.gpss.api.vo;

import java.util.Date;

public class Employee {
	private String name;
	private String mobile;
	private String eid;
	private Date birthday;
	private String etypeid;
	private String etypeName;
	private Date updatedtime;
	private String updater;
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
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEtypeid() {
		return etypeid;
	}
	public void setEtypeid(String etypeid) {
		this.etypeid = etypeid;
	}
	public String getEtypeName() {
		return etypeName;
	}
	public void setEtypeName(String etypeName) {
		this.etypeName = etypeName;
	}
	public Date getUpdatedtime() {
		return updatedtime;
	}
	public void setUpdatedtime(Date updatedTime) {
		this.updatedtime = updatedTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", mobile=" + mobile + ", eid=" + eid + ", birthday=" + birthday
				+ ", etypeid=" + etypeid + ", etypeName=" + etypeName + ", updatedTime=" + updatedtime + ", updater="
				+ updater + "]";
	}

	
	
	
}
