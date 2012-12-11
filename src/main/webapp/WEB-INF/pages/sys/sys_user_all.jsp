<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户管理</title>
<link rel="stylesheet" href="/css/admin.css" />
<link rel="stylesheet" href="/css/global.css" />
<script type='text/javascript'
	src='<c:url value="/js/jquery-1.8.2.js"/>'></script>

<style>
.msg_error_tip_l {
	display: inline-block;
	visibility: inherit;
	padding: 0 0 0px 19px;
	background: url(/png/icon.png) no-repeat -196px -48px;
	color: #E30806;
	margin: 0 0 0 100px;
	font-family: Tahoma;
	font-size: 12px;
}
.msg_error_tip_r {
  display: inline-block;
  visibility: inherit;
  padding: 0 0 0px 19px;
  background: url(/png/icon.png) no-repeat -196px -48px;
  color: #E30806;
  margin: 0 0 0 390px;
  font-family: Tahoma;
  font-size: 12px;
}
.texthidden {
  width: 100px; /*宽度，超过即会溢出*/
  line-height: 25px; /*设置行间距*/
  text-overflow: ellipsis; /*当文本溢出时显示…此时还必须定义：
强制文本在一行内显示（white-space:nowrap）及溢出内容为隐藏（overflow:hidden）*/
  white-space: nowrap; /*表示文本不会换行*/
  overflow: hidden; /*表示溢出的内容会被隐藏*/
}
</style>

</head>
<body>
	<br />
	<input type="hidden" id="actionMethod" value="" />
	<h3 class="Hr radius12-lr ml10 w135 " id="actionTitle">创建用户</h3>
	<form:form action="/sys/user/save.do?action=new" commandName="sysUser"
		id="mainForm">
		<form:hidden path="userId" />
		<div class="Dgw ml10 mb10 w600">
			<dl class="colunm c2T4D8 cdg ">
				<dt>用户名：</dt>
				<dd>
					<form:input path="loginName" cssClass="Bgray h20 w100 pl5" />
				</dd>
				<dt>密码：</dt>
				<dd>
					<form:password path="loginPwd" cssClass="Bgray h20 w100 pl5" />
				</dd>
			</dl>
        <form:errors path="loginName" cssClass="msg_error_tip_l ml20"></form:errors>
        <form:errors path="loginPwd" cssClass="msg_error_tip_r ml20"></form:errors>
			<dl class="colunm c2T4D8 cdg ">
				<dt>姓名：</dt>
				<dd>
					<form:input path="userName" cssClass="Bgray h20 w100 pl5" />
				</dd>
				<dt>性别：</dt>
				<dd>
					<form:radiobutton path="userSex" value="1" />
					男
					<form:radiobutton path="userSex" value="0" />
					女
				</dd>
			</dl>
			<div>
        <form:errors path="userName" cssClass="msg_error_tip_l ml20"></form:errors>
        <form:errors path="userSex" cssClass="msg_error_tip_r ml20"></form:errors>
      </div>
			<dl class="colunm c2T4D8 cdg ">
				<dt>所属部门：</dt>
				<dd>
					<form:select path="department" 
						cssClass="w100">
						<form:options items="${departments }" itemLabel="constantName"
							itemValue="constantCode" />
					</form:select>
				</dd>
				<dt></dt>
				<dd></dd>
			</dl>
      <div>
        <form:errors path="department" cssClass="msg_error_tip_l ml20"></form:errors>
      </div>
			<dl class="colunm c2T4D8 cdg ">
				<dt>邮箱：</dt>
				<dd>
					<form:input path="email" 
						cssClass="Bgray h20 w100 pl5" />
				</dd>
				<dt>手机：</dt>
				<dd>
					<form:input path="mobile" 
						cssClass="Bgray h20 w100 pl5" />
				</dd>
			</dl>
      <div>
        <form:errors path="email" cssClass="msg_error_tip_l ml20"></form:errors>
        <form:errors path="mobile" cssClass="msg_error_tip_r ml20"></form:errors>
      </div>
			<label class="mt10 mr10 ml10 mb10">角色:</label>
			<p class="">
				<c:forEach items="${roles }" var="role">
					<label class="mr10 ml10 mb10"> <form:checkbox
							disabled="false" path="roleIds"
							value="${role.roleId }" label="${role.roleName }" />
					</label>
				</c:forEach>
			</p>
        <form:errors path="roleIds" cssClass="msg_error_tip_l ml20"></form:errors>
        
			<div class="mb10 mt10 ml10 tac">
				<input type="button" id="actionBtn_new" value="新用户"
					class="btn Borange fw7"
					onclick="javascript:document.location.reload();" /> 
				<input
					type="submit" id="actionBtn_save" value="保存用户"
					class="btn Borange fw7" /> 
				<input type="submit"
					id="actionBtn_update" value="修改用户" class="btn Borange fw7"
					style="display: none;" /> 
				<input type="button"
					id="actionBtn_audit" value="审核通过" class="btn Borange fw7"
					style="display: none;" onclick="javascript:if(confirm('确实审核通过吗?')) document.form[0].submit();" /> 
				<input type="reset" value="重置"
					class="btn Borange fw7" />
			</div>
		</div>
	</form:form>

	<h3 class="Hr w800 ml10"></h3>
	<table class="tab mb10 ml10 " style="width: 800px;">
		<thead>
			<tr>
				<th style="width: 8%;">用户名</th>
				<th style="width: 8%;">姓名</th>
				<th style="width: 5%;">性别</th>
				<th style="width: 8%;">部门</th>
				<th style="width: 12%;">手机</th>
				<th style="width: 15%;">邮箱</th>
				<th style="width: 10%;">角色</th>
				<th style="width: 6%;">状态</th>
				<th style="width: 15%;">操作时间</th>
				<th style="width: 10%;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageInfo.resultSet }" var="user">
				<tr>
					<td class="crb">${user.loginName }</td>
					<td>${user.userName }</td>
					<td><c:choose>
							<c:when test="${user.userSex==1 }">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose></td>
					<td><c:forEach items="${departments }" var="department">
							<c:if test="${department.constantCode eq user.department }"> ${department.constantName }</c:if>
						</c:forEach></td>
					<td>${user.mobile }</td>
					<td>${user.email }</td>
					<td><label class="texthidden ml5"> <c:forEach
								var="role" items="${user.roles }">
								<c:out value="${role.roleName}" />,
                        </c:forEach>
					</label></td>
					<td>${user.statusDesc }</td>
					<td><fmt:formatDate value="${user.createDate }"
							pattern="yyyy年MM月dd日HH点mm分ss秒"></fmt:formatDate></td>
					<td class="brlg"><a
						href="javascript:viewUser(${user.userId })" class="cdr">查看</a> <a
						href="javascript:editUser(${user.userId })" class="cdr">修改</a> <c:if
							test="${user.auditStatus==0 }">
							<a href="javascript:auditUser(${user.userId })" class="cdr">审核</a>
						</c:if></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page tal cdg ml10">
		【每页${pageInfo.pageSize }条&nbsp;&nbsp;共${pageInfo.pageCount
		}页&nbsp;&nbsp;当前第 ${pageInfo.currentPage }页 】 <a class="mh5 fw7"
			href="/sys/user/list.do?pageNo=1">首页</a>
		<c:if
			test="${pageInfo.currentPage>1 && pageInfo.currentPage<=pageInfo.pageCount }">
			<a class="mh5 fw7"
				href="/sys/user/list.do?pageNo=${pageInfo.currentPage - 1 }">上一页</a>
		</c:if>
		<c:if
			test="${pageInfo.currentPage>=1 && pageInfo.currentPage<pageInfo.pageCount }">
			<a class="mh5 fw7"
				href="/sys/user/list.do?pageNo=${pageInfo.currentPage + 1 }">下一页</a>
		</c:if>
		<a class="mh5 fw7"
			href="/sys/user/list.do?pageNo=${pageInfo.pageCount}">尾页</a>
	</div>

	<script language="javascript">
		var actionMethod = document.getElementById("actionMethod");
		var action = actionMethod.value;
		var btnNew = document.getElementById("actionBtn_new");
		var btnSave = document.getElementById("actionBtn_save");
		var btnUpdate = document.getElementById("actionBtn_update");
		var btnAudit = document.getElementById("actionBtn_audit");
		var frm = document.getElementById("mainForm");

		if (action == "new") {
			btnNew.style = "display:;";
			btnSave.style = "display:;";
			btnUpdate.style = "display:none;";
			btnAudit.style = "display:none;";
			frm.action = "/sys/user/save.do?action=new";
		}

		if (action == "update") {
			btnNew.style = "display:none;";
			btnSave.style = "display:none;";
			btnUpdate.style = "display:;";
			btnAudit.style = "display:none;";
			frm.action = "/sys/user/save.do?action=update";
		}
		if (action == "audit") {
			btnNew.style = "display:;";
			btnSave.style = "display:none;";
			btnUpdate.style = "display:none;";
			btnAudit.style = "display:;";
			frm.action = "/sys/user/save.do?action=audit";
		}
	</script>
</body>
</html>