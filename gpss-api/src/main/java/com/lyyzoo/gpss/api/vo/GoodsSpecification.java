package com.lyyzoo.gpss.api.vo;

public class GoodsSpecification {
	private String gspecificationId;
	private String name;
	private String gspecificationType;
	private String description;
	public String getGspecificationId() {
		return gspecificationId;
	}
	public void setGspecificationId(String gspecificationId) {
		this.gspecificationId = gspecificationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGspecificationType() {
		return gspecificationType;
	}
	public void setGspecificationType(String gspecificationType) {
		this.gspecificationType = gspecificationType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GoodsSpecification [gspecificationId=" + gspecificationId + ", name=" + name + ", gspecificationType="
				+ gspecificationType + ", description=" + description + "]";
	}
}
