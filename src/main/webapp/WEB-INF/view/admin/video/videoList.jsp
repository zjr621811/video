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
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-confirm.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/jquery-confirm.min.css" rel="stylesheet">
     
    <title></title>
    
    <script type="text/javascript">
    	var deleteNum = 0;
    	function checkDelete(ele){
    		if(ele.checked){
    			deleteNum++;
    		}else{
    			deleteNum--;
    		}
    		$("#countSpan").text(deleteNum);
    		if(deleteNum == $("input[name=checkid]").length){
    			$("#checkAll").prop("checked",true);
    		}else{
    			$("#checkAll").prop("checked",false);
    		}
    	}
    
    	function checkAllElement(ele){
    		$("input[name=checkid]").prop("checked",ele.checked);
    		if(ele.checked){
    			deleteNum=$("input[name=checkid]").length;
    		}else{
    			deleteNum=0;
    		}
    		$("#countSpan").text(deleteNum);
    	}
    
    	function batchDelete(){
    		if(deleteNum == 0){
    			$.alert({
    				title:'警告',
    				content:'没选,删啥子哟!',
    			});
    			return;
    		}
    		$.confirm({
    		    title: '提示',
    		    content: '看清点,删了可就没有了!!!!',
    		    buttons: {
    		        confirm:{ 
    		        	text: '非常肯定',
    		        	action:function () {
    		            $("#deleteForm").submit();
    		        }
    		     },
    		        	取消: function () {
    		            
    		        }
    		        
    		    }
    		});
    	}
    	function deleteInfo(id){
    		$.confirm({
    		    title: '提示',
    		    content: '看清点,删了可就没有了!!!!',
    		    buttons: {
    		        confirm:{ 
    		        	text: '非常肯定',
    		        	action:function () {
    		        	$.ajax({
    		            url:"${pageContext.request.contextPath}/admin/video/deleteVideo.action",
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
            <li class="active"><a href="${pageContext.request.contextPath}/admin/video/videoList.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/speaker/speakerList.action">主讲人管理</a></li>
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
        <h2>视频列表-视频管理</h2>
      </div>
      
      <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/admin/video/addVideo.action">添加视频</a>
      <button type="button" class="btn btn-primary" onclick="batchDelete()">批量删除<span class="badge" id="countSpan">0</span></button>
      
	<div style="float: right;">
    <form class="form-inline" action="${pageContext.request.contextPath }/admin/video/videoList.action" method="post">
    <input type="text" placeholder="视频标题" class="form-control" name="videoTitle" value="${videoTitle}">
    
    
    <select class="form-control" name="videoSpeaker">
      <option value="0">请选择主讲人</option>
		<c:forEach var="speaker" items="${speakerList }">
		<option value="${speaker.id}" ${VideoVO.videoSpeaker == speaker.id ? "selected":""}>${speaker.speakerName}</option>
		</c:forEach>
	</select>
	
	
	<select class="form-control"  name="videoCourse">
      <option value="0">请选择课程</option>
     <c:forEach var="course" items="${courseList }">
     <option value="${course.id}" ${VideoVO.videoCourse == course.id ? "selected":""}>${course.courseName}</option>
     </c:forEach>
	</select>
    
  <input type="submit" class="btn btn-primary" value="查询">
  </form> 
	 </div>
<form action="${pageContext.request.contextPath }/admin/video/batchDelete.action" id="deleteForm" method="get">
     <table class="table table-hover">
            <thead>
              <tr>
              	<th><input type="checkbox" onclick="checkAllElement(this)" id="checkAll"/></th>
                <th>序号</th>
                <th>名称</th>
                <th class="col-md-7">介绍</th>
                <th>讲师</th>
                <th>课程</th>
                <th>时长(秒)</th>
                <th>播放次数</th>
                <th>编辑</th>
                <th>删除</th>
              </tr>
            </thead>
         <c:forEach var="video" items="${page.rows }" varStatus="status" >
          <tr>
            <td><input type="checkbox" onclick="checkDelete(this)" name="checkid" value="${video.id }"/></td>
            <td>${status.count+(page.page-1)*5}</td>
            <td>${video.videoTitle}</td>
            <td>${video.videoDescr}</td>
            <td>${video.s.speakerName }</td>
            <td>${video.c.courseName }</td>
            <td>${video.videoLength}</td>
            <td>${video.videoPlayTimes}</td>
            <td><a class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/admin/video/updateVideo.action?id=${video.id}"></a></td>
            <td><a class="glyphicon glyphicon-trash" href="#" onclick="deleteInfo(${video.id})"></a></td>
          </tr>
        </c:forEach>        
	</table> 
</form> 
	 <ll:page url="${pageContext.request.contextPath}/admin/video/videoList.action"></ll:page>
	

</html>
