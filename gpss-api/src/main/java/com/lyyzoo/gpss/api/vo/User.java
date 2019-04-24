package com.lyyzoo.gpss.api.vo;

import java.util.Date;

import lombok.Data;

/**
 * 系统用户
 * @author Administrator
 *
 */
@Data
public class User {
	private String uid;
	private String name;
	private String password;
	private int locked;
	private String eid;
	private Date updatedTime;
	private String roleName;
	private String roleCode;
	private String rid;
}
