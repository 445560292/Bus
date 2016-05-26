<!DOCTYPE html>
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


</head>
<body id="Body">
<div id="container" style="background: #FFF;">
    <div id="content" style="background: #FFF;">
        <div style="font-size: 16px; font-weight: bold; font-family: 宋体;">

        </div>

        <g:each status="i" var="result" in="${data}">
        <div id="huancheng">
            <div id="huancheng_title">
                <span class="index"> ${i}</span>
                ${result[0].name} → <g:if test="${change == true}">
                ${sameStation[i]} →
            </g:if>  ${result[result.size()-1].name}
            </div>
            <div id="huancheng_content" style="width: 720px; height: auto;padding-left: 50px;">
                <p id="start">
                    <span class="start"></span> <strong style="color:#eb6100 ;font-size:20px;"> ${result[0].line} 上</strong>
                <g:each var="station" in="${result}">
                    <a href="/Bus/search/stationLocation?station= ${station.name}" style="line-height:28px; font-size:20px ;"> ${station.name + "  "}</a>
                    <g:if test="${change == true}">
                    <g:if test="${station.name == sameStation[i] && station.line == result[result.size()-1].line}">
                            <p style="line-height:38px;padding-left:48px;color:#eb6100; font-size:20px; font-weight:bold; ">换乘站： ${sameStation[i]}</p>
                            <p style="line-height:28px;color:#eb6100; font-size:20px ;padding-left:48px; ">乘<span style="color:#0b56c7;">${station.line}</span> 到</p>
                        </g:if>
                    </g:if>
                </g:each>
                </p>
                <p  id="end">
                    <span class="end"></span>${result[result.size()-1].name}</p>
            </div>
            <br style="clear: both" />
        </div>
        </g:each>

    </div>
</div>

<div id="bottom_bg"></div>
</body>
</html>