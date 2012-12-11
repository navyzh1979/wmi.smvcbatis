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
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>角色管理列表</title>
<link rel="stylesheet" href="/css/admin.css" />
<link rel="stylesheet" href="/css/global.css" />

</head>
<body>
	<br />
	<h3 class="Hr w700 ml10">
		<a href="/sys/role/new.do">创建一个新角色</a>
	</h3>
	<p class="result mb10">&nbsp;</p>
	<table class="tab mb10 ml10" style="width: 700px;">
		<thead>
			<tr>
				<th style="width: 10%;">角色名称</th>
				<th style="width: 40%;">角色权限</th>
				<th style="width: 10%;">状态</th>
				<th style="width: 25%;">操作时间</th>
				<th style="width: 15%;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageInfo.resultSet }" var="role">
				<tr>
					<td class="crb">${role.roleName }</td>
					<td>
						<label class="texthidden ml5">
						<c:forEach var="rightName" items="${role.roleRightNames }">
							<c:out value="${rightName}" />,
						</c:forEach> 
						</label>
					</td>
					<td>${role.statusDesc }</td>
					<td><fmt:formatDate value="${role.createDate }"
							pattern="yyyy年MM月dd日HH点mm分ss秒"></fmt:formatDate>
					</td>
					<td class="brlg">
					  <a href="/sys/role/view.do?roleId=${role.roleId }&action=view" class="cdr">查看</a> 
					  <a href="/sys/role/edit.do?roleId=${role.roleId }" class="cdr">修改</a> 
						<c:if test="${role.auditStatus==0 }">
							<a href="/sys/role/view.do?roleId=${role.roleId }&action=audit" class="cdr">审核</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page tal cdg ml10">
		【每页${pageInfo.pageSize }条&nbsp;&nbsp;共${pageInfo.pageCount }页&nbsp;&nbsp;当前第 ${pageInfo.currentPage }页 】
		<a
			class="mh5 fw7" href="/sys/role/list.do?pageNo=1">首页</a>
		<c:if
			test="${pageInfo.currentPage>1 && pageInfo.currentPage<=pageInfo.pageCount }">
			<a class="mh5 fw7" href="/sys/role/list.do?pageNo=${pageInfo.currentPage - 1 }">上一页</a>
		</c:if>
		<c:if
			test="${pageInfo.currentPage>=1 && pageInfo.currentPage<pageInfo.pageCount }">
			<a class="mh5 fw7" href="/sys/role/list.do?pageNo=${pageInfo.currentPage + 1 }">下一页</a>
		</c:if>
		<a class="mh5 fw7" href="/sys/role/list.do?pageNo=${pageInfo.pageCount}">尾页</a>
	</div>
</body>
</html>
