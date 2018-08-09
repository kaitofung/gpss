package com.lyyzoo.gpss.api.vo;

public class Role {
	private int rid;
	private String name;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", roleName=" + name + "]";
	}
	
}
