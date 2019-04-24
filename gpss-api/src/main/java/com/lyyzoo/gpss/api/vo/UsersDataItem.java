package com.lyyzoo.gpss.api.vo;

import java.util.Date;

import lombok.Data;

@Data()
public class UsersDataItem {
	private String uid;
	private String realName;
	private String password;
	private String roleName;
	private String rid;
	private String nickName;
	private int locked;
	private int eid;
	private Date updatedTime;
}
