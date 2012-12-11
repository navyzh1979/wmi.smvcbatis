/**
 *
 * @author geloin
 * @date 2012-5-8 下午2:48:25
 */
package org.wmichina.crm.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author geloin
 * @date 2012-5-8 下午2:48:25
 */
public class MyAuthenticator extends Authenticator {
	private String username;
	private String password;

	/**
	 * 
	 * @author geloin
	 * @date 2012-5-8 下午2:48:53
	 * @param username
	 * @param password
	 */
	public MyAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
	
	/**
	* 获取客户端IP 
	* @param request
	* @return
	*/
	public static String getIpAddr(HttpServletRequest request) {
	        String ip = request.getHeader("X-Forwarded-For");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    }
}
