<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li><a href="${pageContext.request.contextPath }/admin/video/videoList.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/admin/course/courseList.action">课程管理</a></li>
            
            <li style="left: 600px;"><a href="#" class="glyphicon glyphicon-log-out"></a></li>
           
          </ul>
        </div>
      </div>
   </nav>
    <div class="container theme-showcase" role="main">
      <div class="jumbotron">
        <h2>编辑课程</h2>
      </div>
      
      <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/course/updateCourse.action" method="post">
     <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属学科</label>
    <div class="col-sm-10">
      <select class="form-control" name="c.subjectId">
      <option>请选择所属学科</option>
      <c:forEach items="${subjectList }" var="subject">
      <option value="${subject.id }" ${subject.id==course.subjectId?" selected":""}>${subject.subjectName}</option>
      </c:forEach>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="课程标题" name="c.courseName" value="${course.courseName }">
    </div>
  </div>
      <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
      <textarea type="text" class="form-control" style="height: 100px;" name="c.courseDescr">${course.courseDescr }</textarea>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="hidden" name="c.id" value="${course.id }">
    	<button type="submit" class="btn btn-primary">保存</button>
    	  <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
    </div>
  </div>
      </form>
</html>
