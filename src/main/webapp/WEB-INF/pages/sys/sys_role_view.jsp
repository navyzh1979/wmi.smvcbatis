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
<title>查看角色信息</title>
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
	<form:form id="mainForm" action="#"
		commandName="sysRole">
		<div class="mainInner">
			<h3 class="Hr w700">查看角色信息</h3>
			<span class="mt20 mr10 ml10 mb20">角色名称：</span> 
			<form:input path="roleName" id="v" cssClass="Bgray h20 w200 pl5" />
			<br /> 
				  <div class="msg_error_tip">
            <form:errors path="roleName"></form:errors>
          </div>
		 <div class="mt10 mr10 ml10 mb10">角色权限
          <label class="msg_error_tip">
            <form:errors path="roleRightCodes"></form:errors>
          </label>
      </div>
			<table class="tab ml10 w600" style="width: 600px;">
				<c:forEach items="${builder.modules }" var="rightModule">
					<tr>
						<td width="13%">${rightModule.branchRight.rightName }</td>
						<td width="87%" class="tal">
						  <c:if test="${rightModule.leafRights!=null}">
								<form:checkboxes cssClass="ml10"
									items="${rightModule.leafRights}" disabled="true" itemLabel="rightName"
									itemValue="rightId" path="roleRightCodes" /><br/>
							</c:if>
							<c:if test="${rightModule.nodeRights!=null}">
								<c:forEach items="${rightModule.nodeRights }" var="nodeRight">
									<form:checkbox disabled="true" cssClass="ml10" label="${ nodeRight.rightName}"
										value="${ nodeRight.rightId}" path="roleRightCodes" />
									<c:if test="${nodeRight.childRights!=null}">
									&nbsp;-[
										<form:checkboxes disabled="true" cssClass="ml10"
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
		    <c:if test="${action=='audit' }">
              <input type="button" value="审核通过" class="btn Borange fw7" 
              onclick="javascript:if(confirm('确实审核通过吗?'))location='/sys/role/audit.do?roleId=${sysRole.roleId}&auditStatus=1';"/>
        </c:if>
			  <input type="button" value="返回" class="btn Borange fw7" onclick="javascript:history.back();"/>
			</div>
		</div>
	</form:form>
</body>
</html>