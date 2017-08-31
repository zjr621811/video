<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ll" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
  
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/jquery-confirm.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-confirm.min.js"></script>
    
    <script type="text/javascript">
    	function deleteInfo(id){
    		$.confirm({
    		    title: '提示',
    		    content: '看清点,删了可就没有了!!!!',
    		    buttons: {
    		        confirm:{ 
    		        	text: '非常肯定',
    		        	action:function () {
    		            $.ajax({
    		            	url:"${pageContext.request.contextPath}/admin/speaker/deleteSpeaker.action",
    		            	dataType:"text",
    		            	type:"post",
    		            	data:{"id":id},
    		            	success:function(msg){
    		            		if(msg == "success"){
    		            			location.reload();
    		            		}
    		            	}
    		            });
    		        }
    		     },
    		        	取消: function () {
    		            
    		        }
    		        
    		    }
    		});
    	}
    
    
    </script> 
 
 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/admin/video/videoList.action">视频管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/course/courseList.action">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/statistics/analyzeList.action">统计分析</a></li>
            <li style="left: 600px;"><a href="#">${admin.loginName}</a></li>
            <li style="left: 600px;"><a href="${pageContext.request.contextPath}/admin/index.jsp" class="glyphicon glyphicon-log-out"></a></li>
           
          </ul>
        </div>
      </div>
   </nav>
    <div class="container theme-showcase">
      <div class="jumbotron">
        <h2>主讲人列表-主讲人管理</h2>
      </div>
      
      
	<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath }/admin/speaker/addSpeaker.action">添加主讲人</a>
	<form action="${pageContext.request.contextPath }/admin/speaker/speakerList.action">
	<div style="float: right;">
    名称<input type="text" placeholder="主讲人名称" name="speakerName">
    职位<input type="text" placeholder="主讲人职位" name="speakerJob">
  <input type="submit" class="btn btn-primary" value="查询">
	 </div>
	<table class="table table-hover">
            <thead>
              <tr>
                <th>序号</th>
                <th>名称</th>
                <th>职位</th>
                <th class="col-md-9">简介</th>
                <th>编辑</th>
                <th>删除</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="speaker" items="${page.rows }" varStatus="status">
              <tr>
                <td>${status.count+(page.page-1)*5}</td>
                <td>${speaker.speakerName}</td>
                <td>${speaker.speakerJob}</td>
                <td>${speaker.speakerDescr}</td>
                <td><a class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/admin/speaker/updateSpeaker.action?id=${speaker.id}"></a></td>
                <td><a class="glyphicon glyphicon-trash" href="#" onclick="deleteInfo(${speaker.id})"></a></td>
                
              </tr>
            </c:forEach>
            </tbody>
	</table>
	<ll:page url="${pageContext.request.contextPath }/admin/speaker/speakerList.action"></ll:page>
	</form>
</html>
