<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/bootstrap.css" />

    <title>服务消息</title>
</head>
<body>

<div class="container">
    <h3 class="h3">已经选择的区域：${section}</h3>
    <h3 class="h3">已经选择的服务类型：${service}</h3>

    <table class="table table-hover">


        <tr>
            <td class="active">欢迎短信</td>
            <td class="success">目的地介绍</td>
            <td class="warning">景区天气</td>
            <td class="danger">客流实时消息</td>
        </tr>
        <tr>
            <td class="active">${message}</td>
            <td class="success">${description}</td>
            <td class="warning">${weather}</td>
            <td class="danger">${info}</td>
        </tr>
    </table>


    </div>

</body>
</html>