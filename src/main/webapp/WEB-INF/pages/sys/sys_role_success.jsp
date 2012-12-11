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
<title>角色操作结果</title>
<link rel="stylesheet" href="/css/admin.css" />
</head>
<body>
  <div class="mainInner">
    <h3 class="Hr w700 tac"><c:out value="${success_msg }"></c:out></h3>
    <div class="mb20 mt20 ml10 w700 tac">
      <a href="/sys/role/new.do" class="btn Borange fw7">继续创建新角色</a>
      <a href="/sys/role/list.do" class="btn Borange fw7">返回列表页</a>
    </div>
  </div>
</body>
</html>