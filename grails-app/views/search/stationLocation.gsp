<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
    body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";font-size:14px;}
    #l-map{height:300px;width:100%;}
    #r-result{width:100%;}
    </style>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xAtEtZe8LeRKoqomjAEp8UHDKppRGYWw"></script>
    <title>关键字输入提示词条</title>
</head>
<body>
<g:hiddenField name="station" value="${station}" id="source"></g:hiddenField>
<div id="l-map"></div>
<div id="r-result"><input type="text" id="suggestId" size="20" value="百度" style="width:150px;" /></div>
<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }


    function G(id) {
        return document.getElementById(id);
    }

    $('#suggestId').text($('#source').val())

    var map = new BMap.Map("l-map");
    map.centerAndZoom(new BMap.Point(120.54, 31.86), 14)
    // 初始化地图,设置城市和地图级别。

    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
            {"input" : "suggestId"
                ,"location" : map
            });

    var local = new BMap.LocalSearch(map, {
        renderOptions:{map: map}
    });
    local.search($('#source').val());
</script>
