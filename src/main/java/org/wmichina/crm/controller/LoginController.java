
package org.wmichina.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.form.LoginForm;
import org.wmichina.crm.service.SysRoleUserService;
import org.wmichina.crm.util.Constants;
import org.wmichina.crm.util.Md5;
import org.wmichina.crm.util.MyAuthenticator;

@Controller
@RequestMapping(value = "")
public class LoginController {
	static Logger log = Logger.getLogger(LoginController.class);
	
	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;

	@RequestMapping(value = "login")
	public ModelAndView toLogin(@ModelAttribute LoginForm loginForm) throws Exception {
		log.info(" go to login page.");
		Map<String, Object> map = new HashMap<String, Object>();
		
		return new ModelAndView("login", map);
	}
	@RequestMapping(value = "dologin")
	public ModelAndView doLogin(@ModelAttribute @Valid LoginForm loginForm, BindingResult result, HttpServletRequest request) throws Exception {
		log.info(" try to login as " + loginForm.getLoginName() +".");
		
		Map<String, Object> map = new HashMap<String, Object>();
		//#1. 字段输入校验 返回错误信息
		if(result.hasErrors()) {
			log.info(" login validate failed, go to login page. ");
			map.put("loginForm", loginForm);
			return new ModelAndView("login", map);
		}
		//#2. 登录校验
		int userLoginId = this.sysRoleUserService.checkLogin(loginForm.getLoginName(), Md5.getMd5(loginForm.getLoginPwd().trim()));
		if(userLoginId == Constants.LOGIN_FAIL_NOTEXISTS){
			log.info(" login checking failed, using not exsits userName: "  + loginForm.getLoginName() +"." );
			FieldError error = new FieldError("sysUser","loginName","用户名不存在！");
			result.addError(error);
		}else if(userLoginId == Constants.LOGIN_FAIL_WRONGPWD){
			log.info(" login checking failed, using wrong password as userName: "  + loginForm.getLoginName() +"." );
			FieldError error = new FieldError("sysUser","loginPwd","密码错误！");
			result.addError(error);
		}else if(userLoginId == Constants.LOGIN_FAIL_EXCEPTION){
			log.info(" login checking failed, unknown exception occured, as userName: "  + loginForm.getLoginName() +"." );
			ObjectError error = new ObjectError("ERROR_MSG","登录异常，请稍候重试或联系系统管理员！");
			result.addError(error);
		} else {
			log.info(" login checking succeed, using userName: "  + loginForm.getLoginName() +", userId is " + userLoginId  + ".");
		}
			
		// 用户名/密码校验 返回错误信息
		if(result.hasErrors()) {
			map.put("loginForm", loginForm);
			log.info(" login checking failed, to to login page. " );
			return new ModelAndView("login", map);
		}
		
		//#3. 保存登录历史
		String loginIP = MyAuthenticator.getIpAddr(request);
		log.info(" save login history, loginIP: " + loginIP);
		
		//#4. 获取用户登录权限及操作菜单.
		log.info(" get rights and roles of " + loginForm.getLoginName() +" ...");
		SysUser loginUser = this.sysRoleUserService.selectOneUser(userLoginId);
		List<SysRight> rights = this.sysRoleUserService.findRightsByUserId(userLoginId);
		List<SysRole> roles = this.sysRoleUserService.findRolesByUserId(userLoginId);
		Map<String, SysRight> rightMap = new HashMap<String,SysRight>();
		Map<Integer, String> roleMap = new HashMap<Integer,String>();
		for(SysRight right : rights){
			rightMap.put(right.getRightCode(), right);
		}
		for(SysRole role : roles){
			roleMap.put(role.getRoleId(),role.getRoleName());
		}
		log.info(" " + loginForm.getLoginName() +" has " + rightMap.size() +" rights and " + roleMap.size() +" roles .");
		//#5. 操作用户登录信息到Session
		log.info(" update user's rights and roles of " + loginForm.getLoginName() +" in session.");
		HttpSession session = request.getSession(true);
		session.setAttribute("rightList", rights);
		session.setAttribute("rightMap", rightMap);
		session.setAttribute("roleList", roles);
		session.setAttribute("roleMap", roleMap);
		session.setAttribute("loginUser", loginUser);
		
		log.info(" login succeed, go to main page.");
		
		return new ModelAndView("main", map);
	}
}