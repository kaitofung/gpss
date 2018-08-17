package com.lyyzoo.gpss.api.vo;

import com.lyyzoo.gpss.api.IPhotoSetter;

public class Goods implements IPhotoSetter{
	private String gid;
	private String name;
	private String gtype_id;
	private String gtype;
	private String producer;
	private String description;
	private String gspecification_id;
	private String gspecification_name;
	private float price;
	private String photo;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGtype_id() {
		return gtype_id;
	}
	public void setGtype_id(String gtype_id) {
		this.gtype_id = gtype_id;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGspecification_id() {
		return gspecification_id;
	}
	public void setGspecification_id(String gspecification_id) {
		this.gspecification_id = gspecification_id;
	}
	public String getGspecification_name() {
		return gspecification_name;
	}
	public void setGspecification_name(String gspecification_name) {
		this.gspecification_name = gspecification_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	@Override
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", name=" + name + ", gtype_id=" + gtype_id + ", gtype=" + gtype + ", producer="
				+ producer + ", description=" + description + ", gspecification_id=" + gspecification_id + ", gspecification_name=" + gspecification_name + ", price="
				+ price + ", photo=" + photo + "]";
	}
	
}
