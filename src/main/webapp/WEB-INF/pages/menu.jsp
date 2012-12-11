<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type='text/javascript'
	src='<c:url value="/dwr/interface/sysRightController.js" />'></script>
<script type="text/javascript">
	function view(obj) {
		var id = obj.value;
		sysRightController.showRight(id, function(data) {
			document.getElementById('view').innerHTML = data;
		});
	}
</script>
</head>
<body>
	<c:forEach items="${result}" var="sysright">  
        ${sysright.rightId}--${sysright.rightLabel}<br />
	</c:forEach>

	<select onchange="javascript:view(this);">
		<c:forEach items="${result}" var="sysright">  
            <option value="${sysright.rightId}" >${sysright.rightLabel}</option>
		</c:forEach>
	</select>
	<div id="view"></div>
	<fmt:message key="main.title"/>
</body>
</html>
