package com.lyyzoo.gpss.freemarker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class BaseFreemarkerView extends FreeMarkerView {
	private static final String BASE_PATH = "base";
	private static final String CONTEXT_PATH = "context";

	@Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		 String scheme = request.getScheme();
		 String serverName = request.getServerName();
		 int port = request.getServerPort();
		 String path = request.getContextPath();
		 String basePath = scheme + "://" + serverName + ":" + port + path;
		 model.put(BASE_PATH, basePath);
		 model.put(CONTEXT_PATH, path);
		 logger.info("===========" + basePath);
		 super.exposeHelpers(model, request);
    }
}
