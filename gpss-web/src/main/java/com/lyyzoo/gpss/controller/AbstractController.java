package com.lyyzoo.gpss.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.IPhotoSetter;

public abstract class AbstractController implements IMappingParameter {
	
	public HttpServletResponse getResponse() {
		return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public void setAttribute(String attributeName, Object value) {
		getRequest().setAttribute(attributeName, value);
	}
	
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
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
