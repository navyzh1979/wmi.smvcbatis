<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>WMICRM</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>

<frameset rows="50,*" cols="*" framespacing="1" border="2" bordercolor="#FF0000" class="myframe"> 
	<frame src="/top.do" name="topFrame" scrolling="No" bordercolor="#FF0000" border="10" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset rows="*" cols="170,*" framespacing="1" border="2" bordercolor="#FF0000" class="myframe" >
       <frame src="/left.do" name="leftFrame" noresize="noresize" id="leftFrame" title="leftFrame" /> 
	   <frame src="/default.htm" name="mainFrame" id="mainFrame" title="mainFrame" />
	</frameset>
</frameset>
<noframes>&lt;body&gt; &lt;/body&gt;</noframes>

</html>