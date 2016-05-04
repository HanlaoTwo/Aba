<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/bootstrap.css" />
    <title>选择服务</title>
</head>
<body>
<div class="container">
    <h1 class="h1">选择服务</h1>
    <h3 class="h3">当前学则的区域为：${section}</h3>
    <form action = "information" id = "ser_ok">
        <div class="form-group">
            <select class="btn btn-default dropdown-toggle" name="s1" id="chose">
                <option value="0" selected="selected">全部服务</option>
                <option value="1">景区服务</option>
                <option value="2">商业消息</option>
                <option value="3">应急处理</option>
            </select>
        </div>
        <input type="hidden" name="service" id="ser_type">
        <button type="button" class="btn btn-default"  onclick="getparm()">Submit</button>
    </form>
</div>
</body>

<script type="text/javascript">
    function getparm(){
    	 var chose = document.getElementById("chose").value;
         var ser_type = document.getElementById("ser_type");
         var submit = document.getElementById("ser_ok");
         ser_type.value = chose;
         submit.submit();
    }
</script>

</html>