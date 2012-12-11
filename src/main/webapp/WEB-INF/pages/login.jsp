<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>WMICRM - 登录</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/global.css" />
<link rel="stylesheet" type="text/css" href="/css/login.css" />
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/login.js"></script>

</head>
<body>
	<form:form id="mainForm" action="dologin.do" commandName="loginForm">
		<div id="top">
			<div class="logo_info"></div>
		</div>

		<div id="main">
			<div id="login">
				<div id="login_window">
					<div class="text top_p">
						<span class="l">用户名：</span>

						<form:input path="loginName" id="loginName" cssClass="input1" />
						<span class="s">请填写用户名</span>
					</div>
					<div class="msg_input block">
						<form:errors path="loginName"></form:errors>
					</div>

					<div class="text">
						<span class="l">密&nbsp;&nbsp;&nbsp;码：</span>
						<form:password path="loginPwd" id="loginPwd" cssClass="input1" />
						<span class="s">请填写密码</span>
					</div>
					<div class="msg_input msg_in block">
						<form:errors path="loginPwd"></form:errors>
					</div>
					<div class="text btn">
						<input class="btn_login" name="submit" accesskey="l" value=""
							tabindex="4" type="submit" /> &nbsp;&nbsp; <a href="#"
							target="_blank">忘记密码</a>
					</div>
					<div id="yzm_help">
						填写您获取的手机验证码；<br /> 如果您的个人资料中没有填写手机号码，<br /> 信网络登录本系统，更新您的个人资料
					</div>
				</div>

				<div class="register">
					还没有帐号？<a href="#">开通新用户</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>

		<div id="msg_error"></div>

		<div id="foot">
			<p></p>
		</div>
	</form:form>
</body>
</html>