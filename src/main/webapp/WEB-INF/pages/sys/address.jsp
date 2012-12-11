<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Address Test</title>
<script type='text/javascript'
	src='<c:url value="/js/jquery-1.8.2.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type='text/javascript'
	src='<c:url value="/dwr/interface/defaultController.js" />'></script>
<script type="text/javascript">
	function doChangeProvince(obj, childLevel) {
		var index = obj.selectedIndex;
		var regionCode = obj.options[index].value;
		if (regionCode == "")
			return;
		defaultController.getRegionsByParentCode(regionCode, childLevel,
				function(data) {
					var regionCity = document.getElementById("regionCity");
					$(regionCity).empty();
					$(regionCity).append(data);
                    var regionCounty = document.getElementById("regionCounty");
                    $(regionCounty).empty();
                    var initstr="请选择区/县...";
                    $(regionCounty).append(initstr);
				});
	}
	function doChangeCity(obj, childLevel) {
		var index = obj.selectedIndex;
		var regionCode = obj.options[index].value;
		if (regionCode == "")
			return;
		defaultController.getRegionsByParentCode(regionCode, childLevel,
				function(data) {
					var regionCounty = document.getElementById("regionCounty");
					$(regionCounty).empty();
					$(regionCounty).append(data);
				});
	}
	function initProvince() {
		defaultController.getRegionsByRegionLevel(1, function(data) {
			var regionProvince = document.getElementById("regionProvince");
			$(regionProvince).empty();
			$(regionProvince).append(data);
		});
	}

	function initContactOthers(objId) {
		defaultController.getAttrContactOthers( function(data) {
            var contactOthers = document.getElementById(objId);
            $(contactOthers).empty();
            $(contactOthers).append(data);
		});
	}
</script>
</head>
<body>
	<ul>
		<li>
			<p>
				<select id="contactOthers" name="contactOthers"
					style="color: rgb(153, 153, 153);" />
		        <input type="text" style="margin-left: 10px;"
					id="otherContact" name="otherContact" maxlength="50" /> 
				<input
					type="button" value="+" onclick="umonitor.addContact(this);" />
			</p>
		</li>
	</ul>
	<script type="text/javascript">
		var count = 0;
		var umonitor = {
			addContact : function(obj) {
				var contact_p = document.createElement('p');
				var contact_select = document.createElement('select');
				$(contact_select).attr({
					id : 'contactOthers_'+count,
					name : 'contactOthers_'+count,
					style : "color: rgb(153, 153, 153);"
				});
				initContactOthers(contact_select.id);

				var contact_input = document.createElement('input');
				$(contact_input).attr({
					type : 'text',
					id : 'otherContact_'+count,
					name : 'otherContact_'+count,
					maxlength : 50,
				    style : "margin-left: 10px; margin-right: 10px;"
				});
				
				var deleteButton = document.createElement('input');
				$(deleteButton).attr('type', 'button').val('-').click(
						function() {
							$(this).parent().remove();
							count--;
						});
				if (count < 4) {
					$(obj).parent().parent().append(contact_p);
					$(contact_p).append(contact_select).append(contact_input)
							.append(deleteButton);
					count++;

				}
			}
		}
	</script>
	<ul>
		<li><label class="label-like">所在地区:</label>
			<p>
				<select id="regionProvince" onchange="doChangeProvince(this,2)"
					title="省" name="regionProvince" style="color: rgb(153, 153, 153);">
					<option value="">请选择省...</option>
				</select> <select id="regionCity" onchange="doChangeCity(this,3)" title="市"
					name="regionCity" style="color: rgb(153, 153, 153);">
					<option value="">请选择市...</option>
				</select> <select id="regionCounty" title="区" name="regionCounty"
					style="color: rgb(153, 153, 153);">
					<option value="">请选择区/县...</option>
				</select> <span style="color: #FF0000;">*</span>
			</p></li>
	</ul>
</body>
</html>

<script type="text/javascript">
	initProvince();
	initContactOthers('contactOthers');
</script>
