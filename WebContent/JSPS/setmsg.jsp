<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../CSS/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>
<div class="container">
    
    <br>
    <br>
    <h3 calss="h3">发布消息:</h3>
<form action="msgpush" method = "post" class="form-horizontal">
    <div class="form-group">
        <label  class="col-sm-2 control-label">区域ID</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="sectionid" placeholder="输入区域id">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">天气</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="weather" placeholder="天气">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">商业消息</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="tration" placeholder="消息">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">应急消息</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="emergency" placeholder="紧急">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">发布</button>
        </div>
    </div>
    <h3 calss="h3">更新区域数据:</h3>
</form>
<form action="setsection" method = "post" class="form-horizontal">
    <div class="form-group">
        <label  class="col-sm-2 control-label">区域ID</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="sectionid" placeholder="输入区域id">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">欢迎短信</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="msg" placeholder="欢迎短信">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">景区介绍</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="descrption" placeholder="景区介绍">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">更新数据</button>
        </div>
    </div>
    
</form>
<div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
           <a href="http://localhost:8080/Aba/JSPS/onetoone.html">
           <button  class="btn btn-default">点对点入口</button>
           </a>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
           <a href="http://localhost:8080/Aba/JSPS/Manager.html">
           <button  class="btn btn-default">消息实时推送入口</button>
           </a>
        </div>
    </div>


</div>
</body>
</html>