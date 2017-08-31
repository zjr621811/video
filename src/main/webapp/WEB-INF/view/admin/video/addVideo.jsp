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
     

    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
 
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
            <li class="active"><a href="${pageContext.request.contextPath }/admin/video/videoList.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course/courseList.action">课程管理</a></li>
            <li><a href="#">统计分析</a></li>
            <li style="left: 600px;"><a href="#">${admin.loginName}</a></li>
            <li style="left: 600px;"><a href="${pageContext.request.contextPath }/admin/index.jsp" class="glyphicon glyphicon-log-out"></a></li>
           
          </ul>
        </div>
      </div>
   </nav>
    <div class="container theme-showcase" role="main">
      <div class="jumbotron">
        <h2>添加视频信息-视频管理</h2>
      </div>
      
  	
<form class="form-horizontal" action="${pageContext.request.contextPath }/admin/video/addVideo.action" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="视频标题" name="videoTitle">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
    <div class="col-sm-10">
      <select class="form-control" name="speakerId">
      <option value="0">请选择主讲人</option>
      <c:forEach items="${speakerList }" var="speaker">
		<option value="${speaker.id }" ${speaker.id==video.speakerId?"selected":""}>${speaker.speakerName}</option>   
      </c:forEach>
      </select>

    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
    <div class="col-sm-10">
      <select class="form-control" name="courseId">
      <option >请选择课程</option>
		<c:forEach items="${courseList }"  var="course">
      <option value="${course.id }" ${course.id==video.courseId?"selected":"" }>${course.courseName }</option>
      </c:forEach>
      </select>
    </div>
  </div>
  
  
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="视频时长(秒)" name="videoLength">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="视频封面图片地址,网络地址" name="videoImageUrl">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="视频播放地址,网络地址" name="videoUrl">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10">
      <textarea class="form-control" style="height: 100px;" name="videoDescr"></textarea>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="hidden" name="id">
    	<button type="submit" class="btn btn-primary">保存</button>
      <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>

    </div>
  </div>
</form>
 </div>
</html>
