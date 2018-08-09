package com.lyyzoo.gpss.api.vo;

import java.util.Date;

/**
 * 系统用户
 * @author Administrator
 *
 */
public class User {
	private String uid;
	private String name;
	private String password;
	private int locked;
	private int eid;
	private Date updatedTime;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", locked=" + locked + ", eid=" + eid
				+ ", updatedTime=" + updatedTime + "]";
	}
	
	
}
