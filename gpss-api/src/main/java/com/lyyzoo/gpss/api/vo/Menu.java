package com.lyyzoo.gpss.api.vo;

public class Menu {
	private String mid;
	private String name;
	private String url;
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", name=" + name + ", url=" + url + ", parentId=" + parentId + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	private String parentId;
}
