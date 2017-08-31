<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <li><a href="${pageContext.request.contextPath }/admin/video/videoList.action">视频管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course/courseList.action">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/statistics/analyzeList.action">统计分析</a></li>
            
            <li style="left: 600px;"><a href="#" class="glyphicon glyphicon-log-out"></a></li>
           
          </ul>
        </div>
      </div>
   </nav>
    <div class="container theme-showcase">
      <div class="jumbotron">
        <h2>编辑主讲人-主讲人管理</h2>
      </div>
      
      <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/speaker/updateSpeaker.action" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="主讲人名字" name="s.speakerName" value="${speaker.speakerName }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="主讲人职业" name="s.speakerJob" value="${speaker.speakerJob }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="主讲人头像地址,网络图片" name="s.speakerHeadUrl" value="${speaker.speakerHeadUrl }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
     <textarea class="form-control" style="height: 100px;" name="s.speakerDescr">${speaker.speakerDescr}</textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="hidden" name="s.id" value="${speaker.id }">
    	<button type="submit" class="btn btn-primary">保存</button>
      <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>

    </div>
  </div>
  </form>
</html>
