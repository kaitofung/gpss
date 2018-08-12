package com.lyyzoo.gpss.api.vo;

public class GoodsType {
	private String gtypeId;
	private String name;
	public String getGtypeId() {
		return gtypeId;
	}
	public void setGtypeId(String gtypeId) {
		this.gtypeId = gtypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GoodsType [gtypeId=" + gtypeId + ", name=" + name + "]";
	}
}
