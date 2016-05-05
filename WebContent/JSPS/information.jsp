<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../CSS/bootstrap.css" />
    <title>服务消息</title>
</head>
<body>
<div class="container">
    <h3 class="h3">已经选择的区域：${section}</h3>
    <table class="table table-hover">
        <tr>
            <td >欢迎短信</td>
            <td class="active">${message}</td>
        </tr>
        <tr>
             <td >目的地介绍</td>
            <td class="success">${description}</td>
        </tr>
        <tr>           
            <td >景区天气</td>
            <td class="warning">${weather}</td>
        </tr>
         <tr>
            <td >客流实时消息</td>
            <td class="danger">${info}</td>
        </tr>
         <tr>
            <td >商业消息</td>
            <td class="success">${tration}</td>
        </tr>
         <tr>
            <td >应急消息</td>
            <td class="active">${emerg}</td>
        </tr>
    </table>
    <a  href="http://localhost:8080/Aba/JSPS/user.html"><button class="btn-info">消息推送</button></a>
    <script style="text/javascript">
        function MSGpush()
        {

        }
    </script>
    </div>
</body>
</html>