package com.buba.stuinfomanager.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WebUtils {
	public final static Logger logger = LoggerFactory.getLogger(WebUtils.class);
	 
	 	/**
	 	 * 获取用户的真正IP地址
	 	 * @param request
	 	 * @return
	 	 */
	 	public static String getRemoteAddr(HttpServletRequest request) {
	 		String ip = request.getHeader("X-Forwarded-For");
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getHeader("Proxy-Client-IP");
	 		}
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getHeader("WL-Proxy-Client-IP");
	 		}
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getHeader("HTTP_CLIENT_IP");
	 		}
	 
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getHeader("X-Real-IP");
	 		}
	 
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	 		}
	 		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
	 			ip = request.getRemoteAddr();
	 		}
	 		if (StringUtils.isNotBlank(ip) && StringUtils.indexOf(ip, ",") > 0) {
	 			String[] ipArray = StringUtils.split(ip, ",");
	 			ip = ipArray[0];
	 		}
	 		return ip;
	 	}
	 
	 	/**
	 	 * 获取本地IP地址
	 	 */
	 	public static String getLocalAddr() throws UnknownHostException {
	 		InetAddress addr = InetAddress.getLocalHost();
	 		return addr.getHostAddress();
	 	}
}
