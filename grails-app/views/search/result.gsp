<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/10 0010
  Time: 上午 10:20
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
    body, html {width: 100%;height: 100%; margin:0;font-family:"微软雅黑";}
    #l-map{height:500px;width:100%;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xAtEtZe8LeRKoqomjAEp8UHDKppRGYWw"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <title>根据起终点名称查询公交换乘</title>
</head>
<body>
<div id="l-map"></div>
<div id="driving_way">
    <g:hiddenField name="source" value="${from}" id="source"></g:hiddenField>
    <g:hiddenField name="des" value="${des}" id="des"></g:hiddenField>
    <div id="r-result"></div>
</div>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    var start = $('#source').val();
    var end =  $('#des').val();
    var map = new BMap.Map("l-map");
    map.centerAndZoom(new BMap.Point(120.54, 31.86), 14);
    map.enableScrollWheelZoom();

    var transit = new BMap.TransitRoute(map, {renderOptions: {map: map},onSearchComplete: function(result){
        if (transit.getStatus() == BMAP_STATUS_SUCCESS){
            var firstPlan = result.getPlan(0);
            // 绘制步行线路
            for (var i = 0; i < firstPlan.getNumRoutes(); i++){
                var walk = firstPlan.getRoute(i);
                if (walk.getDistance(false) > 0){
                    // 步行线路有可能为0
                    map.addOverlay(new BMap.Polyline(walk.getPath(), {lineColor: "green"}));
                }
            }
            // 绘制公交线路
            for (i = 0; i < firstPlan.getNumLines(); i++){
                var line = firstPlan.getLine(i);
                map.addOverlay(new BMap.Polyline(line.getPath()));
            }
            // 输出方案信息
            var s = [];
            for (i = 0; i < result.getNumPlans(); i++){
                s.push((i + 1) + ". " + result.getPlan(i).getDescription(false));
            }
            document.getElementById("r-result").innerHTML = s.join("<br/>");
        }
    }
    });
    transit.search(start, end);
</script>
