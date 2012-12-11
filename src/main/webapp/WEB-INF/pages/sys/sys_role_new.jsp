<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>创建新角色</title>
<link rel="stylesheet" href="/css/admin.css" />
<link rel="stylesheet" type="text/css" href="/css/global.css" />
<link rel="stylesheet" type="text/css" href="/css/login.css" />
<style>
.msg_error_tip {
	display: block;
	visibility: inherit;
	padding: 0 0 0px 19px;
	background: url(/png/icon.png) no-repeat -196px -48px;
	color: #E30806;
	margin: 0 0 0 80px;
	font-family: Tahoma;
	font-size: 12px;
}
</style>
</head>
<body>
	<form:form id="mainForm" action="/sys/role/save.do"
		commandName="sysRole">
		<div class="mainInner">
			<h3 class="Hr w700">创建新角色</h3>
			<span class="mt20 mr10 ml10 mb20">角色名称：</span> 
			<form:input path="roleName" id="v" cssClass="Bgray h20 w200 pl5" />
			<br /> 
				  <div class="msg_error_tip ml20">
            <form:errors path="roleName"></form:errors>
          </div>
      <br /> 
		 <span class="mt20 mr10 ml10 mt20">角色权限：</span> 
          <div class="msg_error_tip ml20 mb10">
            <form:errors path="roleRightCodes"></form:errors>
          </div>
  
			<table class="tab ml10 mt10 w600" style="width: 600px;">
				<c:forEach items="${builder.modules }" var="rightModule">
					<tr>
						<td width="13%">${rightModule.branchRight.rightName }</td>
						<td width="87%" class="tal">
						  <c:if test="${rightModule.leafRights!=null}">
								<form:checkboxes cssClass="ml10"
									items="${rightModule.leafRights}" itemLabel="rightName"
									itemValue="rightId" path="roleRightCodes" /><br/>
							</c:if>
							<c:if test="${rightModule.nodeRights!=null}">
								<c:forEach items="${rightModule.nodeRights }" var="nodeRight">
									<form:checkbox cssClass="ml10" label="${ nodeRight.rightName}"
										value="${ nodeRight.rightId}" path="roleRightCodes" />
									<c:if test="${nodeRight.childRights!=null}">
									&nbsp;-[
										<form:checkboxes cssClass="ml10"
											items="${nodeRight.childRights}" itemLabel="rightName"
											itemValue="rightId" path="roleRightCodes" />
									&nbsp;&nbsp;]
									</c:if>
									<br/>
								</c:forEach>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="mb20 mt20 ml10">
				<input type="submit" value="保存角色" class="btn Borange fw7" /> 
				<input type="reset" value="重置" class="btn Borange fw7" /> 
        <input type="button" value="返回" class="btn Borange fw7" onclick="javascript:document.location='/sys/role/list.do';"/>
			</div>
		</div>
	</form:form>
</body>
</html>