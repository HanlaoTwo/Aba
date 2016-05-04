
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<HEAD>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../CSS/bootstrap.min.css" />
<TITLE>选择区域</TITLE>
</HEAD>
<BODY>
	<div class="container">
		<script type="text/javascript">
			var action0 = "service";
			function setparm() {
				var sectionAction = document.getElementById("choses");
				var s1 = document.getElementById("select");
				var i = document.getElementById("id");
				i.value = s1.value;
				sectionAction.action = action0;
				sectionAction.submit();
				sectionAction.submit();
			}
			function setparm1() {
				//设置成当前区域
				var sectionAction = document.getElementById("choses");
				var i = document.getElementById("id");
				i.value = "now";
				sectionAction.action = action0;
				sectionAction.submit();
			}
			function setparm2() {
				//设置成全区
				var sectionAction = document.getElementById("choses");
				sectionAction.action = action0;
				var i = document.getElementById("id");
				i.value = "all";
				sectionAction.submit();
			}
			function setSection0() {

			}
		</script>


		<Form method="get" id="choses">
			<input name="section" id="id" type="hidden">
		</Form>
		<button type="submit" class="btn btn-info" value="选择当前区域"
			onclick="setparm1()">选择当前区域</button>
		<br>
		<button type="submit" class="btn btn-info" value="选择当前区域"
			onclick="setparm2()">选择全区</button>
		<br>
		 <select name="s1" id ="select">
			<option value="0" selected="selected">请选择</option>
			<option value="1">地区1</option>
			<option value="2">地区2</option>
			<option value="3">地区3</option>
			<option value="4">地区4</option>
			<option value="5">地区5</option>
			<option value="6">地区6</option>
			<option value="7">地区7</option>
		</select> 
		<button type="submit" class="btn btn-info"
			onClick="setparm()"> value="确定提交"</button>
	</div>
</BODY>
</HTML>