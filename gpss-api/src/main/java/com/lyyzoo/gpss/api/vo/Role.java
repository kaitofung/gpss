package com.lyyzoo.gpss.api.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
public class Role {
	@Setter
	@Getter
	private int rid;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String roleCode;
	@Setter
	@Getter
	private Date CreatedTime;
	@Setter
	@Getter
	private String description;
	@Setter
	@Getter
	private String menuList;
	
	
}
