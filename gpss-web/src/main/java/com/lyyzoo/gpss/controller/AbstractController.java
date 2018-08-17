package com.lyyzoo.gpss.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.lyyzoo.gpss.api.IPhotoSetter;

public abstract class AbstractController {
	
	public HttpServletResponse getResponse() {
		return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public void setAttribute(String attributeName, Object value) {
		getRequest().setAttribute(attributeName, value);
	}
	
	protected void setPhoto(IPhotoSetter goods, MultipartFile photox, boolean processNullFile) throws IOException {
		if(photox !=null && !photox.isEmpty()) {
			String suffix = photox.getOriginalFilename().substring(photox.getOriginalFilename().lastIndexOf("."));
			String path = getRequest().getServletContext().getRealPath("/upload/") + UUID.randomUUID() + suffix;
			System.err.println(path);
			photox.transferTo(new File(path));
			goods.setPhoto(path);
		} else {
			if(processNullFile) {
				goods.setPhoto("");
			}
		}
	}
}
