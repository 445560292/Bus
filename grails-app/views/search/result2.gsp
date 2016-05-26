<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/20 0020
  Time: 上午 9:58
--%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <asset:stylesheet src="style.css"/>
    <asset:stylesheet src="style1.css"/>
    <script type="text/javascript" src="js/convert1.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xAtEtZe8LeRKoqomjAEp8UHDKppRGYWw"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <style type="text/css">
    * {
        padding: 0;
        margin: 0;
    }

    .li {
        float: left;
        width: 20px;
        list-style: none;
    }

    .bg1 {
        color: red;
    }

    .bg2 {
        color: blue;
    }

    #allmap {
        width: 94%;
        height: 550px;
        overflow: hidden;
        margin: 0 auto;
    }

    #l-map {
        height: 100%;
        width: 78%;
        float: left;
        border-right: 2px solid #bcbcbc;
    }

    #r-result {
        height: 100%;
        width: 20%;
        float: left;
    }

    .span1 {
        color: red;
        font-weight: bold;
    }
    </style>
    <script type="text/javascript">
        $(function () {
            $(".addbus1").append("<img class='bus1' src='images/bus1.jpg' />");
            $(".addbus2").append("<img class='bus2' src='images/bus2.jpg' />");
        })
    </script>

</head>
<body id="Body">
<div id="container" style="background: #FFF;">
    <div id="content" style="background: #FFF;">
        <div style="font-size: 16px; font-weight: bold; font-family: 宋体;">

        </div>

        <div id="huancheng">
            <div id="huancheng_title">
                <span class="index"> 1</span> ${data[0].name} → ${data[data.size()-1].name}
            </div>
            <div id="huancheng_content" style="width: 720px; height: auto;padding-left: 50px;">
                <p id="start">
                    <span class="start"></span> ${data[0].name}
                <g:each var="result" in="${data}">
                    <a href="/Bus/search/stationLocation?station= ${result.name}">  <p> ${result.line}: ${result.name}</p></a>
                </g:each>
            </p>
                <p  id="end">
                    <span class="end"></span> ${data[data.size()-1].name}</p>
            </div>
            <br style="clear: both" />
        </div>
        <div style="background: url(images/content_bottombg.jpg) no-repeat center -7px; height: 21px;">
        </div>
    </div>
</div>

<div id="bottom_bg"></div>
</body>
</html>
