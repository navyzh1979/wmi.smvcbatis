package org.wmichina.crm.interceptor;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysJobTagNoticeService;
import org.wmichina.crm.service.SysRoleUserService;

@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;
	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;
	@Resource(name = "sysJobTagNoticeService")
	private SysJobTagNoticeService sysJobTagNoticeService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SysCache.getInstance().initCache(sysRoleUserService, sysDefaultService, sysJobTagNoticeService);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 后台session控制
		String[] noFilters = new String[] { "login.do", "index.do", "logout.do" };
		String uri = request.getRequestURI();

		if (uri.indexOf("background") != -1) {
			boolean beFilter = true;
			for (String s : noFilters) {
				if (uri.indexOf(s) != -1) {
					beFilter = false;
					break;
				}
			}
			if (beFilter) {
				Object obj = request.getSession().getAttribute("LOGINED");
				if (null == obj) {

					// 未登录
					PrintWriter out = response.getWriter();
					StringBuilder builder = new StringBuilder();
					builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
					builder.append("alert(\"页面过期，请重新登录\");");
					builder.append("window.top.location.href=\"");
					builder.append(request.getServletPath());
					builder.append("/background/index.html\";</script>");
					out.print(builder.toString());
					out.close();
					return false;
				} else {
					/*
					 * // 添加日志 String operateContent =
					 * Constants.operateContent(uri); if (null !=
					 * operateContent) { String url =
					 * uri.substring(uri.indexOf("background")); String ip =
					 * request.getRemoteAddr(); Integer userId =
					 * ((SystemUserForm) obj).getId(); SystemLoggerForm form =
					 * new SystemLoggerForm(); form.setUserId(userId);
					 * form.setIp(ip); form.setOperateContent(operateContent);
					 * form.setUrl(url); this.systemLoggerService.edit(form); }
					 */
				}
			}
		}

		Map paramsMap = request.getParameterMap();

		for (Iterator<Map.Entry> it = paramsMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = it.next();
			Object[] values = (Object[]) entry.getValue();
			for (Object obj : values) {
				/*
				 * if (!DataUtil.isValueSuccessed(obj)) { throw new
				 * RuntimeException("有非法字符：" + obj); }
				 */
			}
		}

		return super.preHandle(request, response, handler);
	}

}
