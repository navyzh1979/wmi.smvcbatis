<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>导入学员信息</title>
</head>
<body>
	<form enctype="multipart/form-data"
		action="/student/do_stlist_import.do" method="post">
		<input type="file" name="uploadFile" id="uploadFile" /><br /> <input
			type="submit" value="上传" />
	</form>
  <h3>-----------------------------------</h3>
  <c:out value="${errorMsg }" />
	<h3>-----------------------------------</h3>
	<c:out value="${isUpdated }" />
	<c:if test="${isUpdated == true }">
	The Uploaded file name is ${fileName }, file length is ${fileLength }.
	</c:if>
</body>
</html>