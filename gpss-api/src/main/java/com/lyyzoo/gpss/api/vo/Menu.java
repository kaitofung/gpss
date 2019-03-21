package com.lyyzoo.gpss.api.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Menu {
	@Setter
	@Getter
	private String mid;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String url;
	@Setter
	@Getter
	private String parentId;
	@Setter
	@Getter
	private String menuIcon;
	@Setter
	@Getter
	private String menuLevel;
	@Setter
	@Getter
	private String admin;
	@Setter
	@Getter
	private String storer;
	@Setter
	@Getter
	private String purchaser;
	@Setter
	@Getter
	private String saler;
}
