<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- saved from url=(0037)http://cs.ule.tom.com/csadmin/left.do -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title></title>
<link rel="stylesheet" type="text/css" href="/css/admin.css" />
<link rel="stylesheet" type="text/css" href="/css/ULE-admin.css" />
</head>
<body id="fLeft">
	<ul class="menu">
		<c:forEach items="${builder.mymenus }" var="menu">
			<li style="white-space: nowrap; cursor: pointer;">${menu.branchRight.rightName}
				<ul class="sec-menu" style="display: none;">
					<c:forEach items="${menu.nodeRights }" var="nodeRight">
						<li style="white-space: nowrap;">
						  <a href="${nodeRight.rightURL }" target="mainFrame">${nodeRight.rightName	}</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</ul>

	<script src="/js/jquery-1.8.2.js"></script>
	<script src="/js/APE-admin.js"></script>
	<script>
		$(function() {
			$(".menu").multiMenu({
				itemStyle : "arrow"
			});
		});
	</script>

</body>
</html>