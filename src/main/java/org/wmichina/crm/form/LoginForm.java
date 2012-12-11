package org.wmichina.crm.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class LoginForm implements Serializable {
	private static final long serialVersionUID = -880445211774578703L;

    @Size(min=4,max=20,message="用户名长度应在4位到20位之间.")
    private String loginName;

    @Size(min=6,max=20,message="密码长度应在6位到20位之间.")
    private String loginPwd;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
}
