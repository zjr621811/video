<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#loginForm").validate({
				rules:{
					loginName:{
						required:true,
						minlength:5
					},
					loginPwd:{
						required:true
					}
				},messages:{
					loginName:{
						required:"用户名不能为空",
						minlength:"长度太小"
					},
					loginPwd:{
						required:"请输入密码"
					}
					
				}
				
			});
		});
	
	</script>
  </head>
  <body>
  	<div style="width:300px; margin: 200px auto;" > 
  		<img src="${pageContext.request.contextPath}/img/logo.png" />
  		
  	<form action="${pageContext.request.contextPath}/admin/user/adminLogin.action" method="post" id="loginForm">
  <div class="form-group">
    <input type="text" class="form-control" name="loginName" placeholder="用户名" value="admin">
  </div>
  <div class="form-group">
    <input type="password" class="form-control" name="loginPwd" placeholder="登录密码" value="admin">
  </div>
  <input type="submit" class="form-control btn btn-success" value="登录">
</form>
   </div>
  </body>
</html>