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
    <script src="${pageContext.request.contextPath }/js/echarts.js"></script>
   
    <script type="text/javascript">
   $(function(){
	  // alert(123);
 	    var theData = "${data}".split(",");
	    var theTimes = "${times}".split(",");
	    
	    var myChart = echarts.init(document.getElementById('main1'));
        // 指定图表的配置项和数据
       var option = {
            color:['#7cb5ed'],
        	title: {
                text: '课程平均播放次数',
                subtext: '数据来源:zhiyou100.com',
                sublink:'http://www.zhiyou100.com',
                left: 'center',
                textStyle: {
                    color: '#323232',
                    fontWeight: 'normal',
                    fontSize: 20
                },
                subtextStyle:{
                    color: '#323232'
                }
            },
            legend: {
                y: 'bottom',
                data: ['平均播放次数'],
                textStyle: {
                	color:'#323232',
                    fontSize: 14,
                    fontWeight:'600'
                },
                icon:'circle'
            },
            tooltip: {},
            xAxis: {
                //data: ["1","2","3","4","5","6"],
               	data: theData,
                axisLabel: {
                    textStyle: {
                        color: '#888'
                    }
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: '#cdd7eb',
                    }
                }
            },
            yAxis: {
            	 name: '平均播放次数(times)',
                 nameLocation: 'middle',
                 nameGap: 40,
                 nameTextStyle: {
                     color: '#888',
                     //fontSize: 16
                 },
                 axisLine: {
                     show: false
                 },
                 axisTick: {
                     show: false
                 }
            },
            series: [{
                name: '平均播放次数',
                type: 'bar',
                barWidth: '33%',
               // data: [1,2,3,4,5,6]
                data: theTimes
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option); 
   });
    </script>
</head> 
<body>
    
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
            <li><a href="${pageContext.request.contextPath}/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/course/courseList.action">课程管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/admin/statistics/analyzeList.action" >统计分析</a></li>
            <li style="left: 600px;"><a href="#" id="main">${admin.loginName}</a></li>
            <li style="left: 600px;"><a href="#" class="glyphicon glyphicon-log-out"></a></li>
           
          </ul>
        </div>
      </div>
   </nav>
   <div class="container theme-showcase" role="main">
      <div class="jumbotron">
        <h2>统计-统计分析</h2>
      </div>
   </div>
	<div class="container">
   
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main1" style="height:400px"> 
    </div>
       </div>
</body>
</html>