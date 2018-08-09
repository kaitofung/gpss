package com.lyyzoo.gpss.api.vo;

import java.util.Date;

/**
 * 系统用户
 * @author Administrator
 *
 */
public class UsersDataItem {
	private String uid;
	private String realName;
	private String roleName;
	private int locked;
	private int eid;
	private Date updatedTime;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		return "UsersDataItem [uid=" + uid + ", realName=" + realName + ", roleName=" + roleName + ", locked=" + locked
				+ ", eid=" + eid + ", updatedTime=" + updatedTime + "]";
	}

	
	
}
