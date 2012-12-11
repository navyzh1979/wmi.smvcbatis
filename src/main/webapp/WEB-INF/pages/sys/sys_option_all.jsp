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
<title>属性选项管理</title>
<link rel="stylesheet" href="/css/admin.css" />
<link rel="stylesheet" href="/css/global.css" />
<script type='text/javascript'
	src='<c:url value="/js/jquery-1.8.2.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type='text/javascript'
	src='<c:url value="/dwr/interface/defaultController.js" />'></script>
<script type="text/javascript"><!--
	function doChangeEntity(obj) {
		var index = obj.selectedIndex;
		var entityCode = obj.options[index].value;
		if (entityCode == ""){
		      var entityAttrs = document.getElementById("attrCode");
		      $(entityAttrs).empty();
		      $(entityAttrs).append("<option value=''>--选择属性--</option>");
		      return;
		}
		defaultController.getAttrByEntityCode(entityCode, function(data) {
			var entityAttrs = document.getElementById("attrCode");
			$(entityAttrs).empty();
			$(entityAttrs).append(data);
		});
	}
</script>
<style>
.msg_error_tip {
	display: block;
	visibility: inherit;
	padding: 0 0 0px 19px;
	background: url(/png/icon.png) no-repeat -196px -48px;
	color: #E30806;
	margin: 0 0 0 90px;
	font-family: Tahoma;
	font-size: 12px;
}
</style>
</head>
<body>
	<br />
	<h3 class="Hr radius12-lr ml10 w150 ">创建/编辑属性选项</h3>
	<form:form action="/sys/option/save.do" commandName="sysConstantOption"
		id="mainForm">
		<form:hidden path="optionId" />
		<form:hidden path="action" id="action" />
		<div class="Dgw ml10 mb10 w600">
			<dl class="colunm c1T4D9 cdg ">
				<dt>所属实体：</dt>
				<dd>
					<form:select path="entityCode" cssClass="w200" onchange="javascript:doChangeEntity(this)">
						<form:option value="" label="--选择实体--"></form:option>
						<c:forEach items="${entities }" var="entity">
							<form:option value="${entity.constantCode }"
								label="${entity.constantName }"></form:option>
						</c:forEach>
					</form:select>
				</dd>
			</dl>
			<div class="msg_error_tip ml20">
				<form:errors path="entityCode"></form:errors>
			</div>
			<dl class="colunm c1T4D9 cdg ">
				<dt>属性名称：</dt>
				<dd>
					<form:select path="attrCode" cssClass="w200">
						<form:option value="" label="--选择属性--"></form:option>
					</form:select>
				</dd>
			</dl>
      <div class="msg_error_tip ml20">
        <form:errors path="attrCode"></form:errors>
      </div>
			<dl class="colunm c1T4D9 cdg ">
				<dt>选项名称：</dt>
				<dd>
					<form:input path="optionName" cssClass="Bgray h20 w200 pl5" />
				</dd>
			</dl>
      <div class="msg_error_tip ml20">
        <form:errors path="optionName"></form:errors>
      </div>
			<dl class="colunm c1T4D16 cdg ">
				<dt>选项描述：</dt>
				<dd style="text-indent: 0px;">
					<form:textarea path="remark" cols="40" rows="3" />
				</dd>
			</dl>
			<div class="mb10 mt10 ml10 tac">
				<input type="button" value="创建新选项" class="btn Borange fw7" /> <input
					type="submit" value="保存新选项" class="btn Borange fw7" /> <input
					type="reset" value="重置" class="btn Borange fw7" />
			</div>
		</div>
	</form:form>

	<h3 class="Hr w700 ml10"></h3>
	<table class="tab mb10 ml10 " style="width: 700px;">
		<thead>
			<tr>
				<th style="width: 15%;">所属实体</th>
				<th style="width: 15%;">属性名称</th>
				<th style="width: 10%;">选项内容</th>
				<th style="width: 15%;">描述</th>
        <th style="width: 10%;">状态</th>
				<th style="width: 20%;">修改时间</th>
				<th style="width: 15%;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageInfo.resultSet }" var="option">
				<tr>
					<td class="crb">${option.entityName }</td>
					<td class="crb">${option.attrName }</td>
					<td>${option.optionName }</td>
					<td class="crb"><label class="texthidden ml5"> ${option.remark } </label>
					</td>
					<td>
					<c:if test="${option.isValid ==0 }">
					    无效
					</c:if>
          <c:if test="${option.isValid ==1 }">
                             有效
          </c:if>
					</td>
					<td><fmt:formatDate value="${option.createDate }"
							pattern="yyyy年MM月dd日HH点mm分ss秒"></fmt:formatDate>
					</td>
					<td class="brlg"><a
						href="/sys/option/edit.do?optionId=${option.optionId }"
						class="cdr">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page tal cdg ml10">
		【每页${pageInfo.pageSize }条&nbsp;&nbsp;共${pageInfo.pageCount
		}页&nbsp;&nbsp;当前第 ${pageInfo.currentPage }页 】 <a class="mh5 fw7"
			href="/sys/option/list.do?pageNo=1">首页</a>
		<c:if
			test="${pageInfo.currentPage>1 && pageInfo.currentPage<=pageInfo.pageCount }">
			<a class="mh5 fw7"
				href="/sys/option/list.do?pageNo=${pageInfo.currentPage - 1 }">上一页</a>
		</c:if>
		<c:if
			test="${pageInfo.currentPage>=1 && pageInfo.currentPage<pageInfo.pageCount }">
			<a class="mh5 fw7"
				href="/sys/option/list.do?pageNo=${pageInfo.currentPage + 1 }">下一页</a>
		</c:if>
		<a class="mh5 fw7"
			href="/sys/option/list.do?pageNo=${pageInfo.pageCount}">尾页</a>
	</div>
</body>
</html>
<script language="javascript">
var entityCode = document.getElementById("entityCode");
doChangeEntity(entityCode);
</script>