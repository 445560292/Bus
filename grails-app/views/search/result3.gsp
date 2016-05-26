<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/20 0020
  Time: 上午 9:58
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
            %{--$(".addbus1").append(" <asset:image src="bus1.jpg"/>");--}%
            %{--$(".addbus2").append(" <asset:image src="bus2.jpg"/>");--}%
        })
    </script>

</head>
<body id="Body">
<div id="container">
    <div id="content">
        <div id="station_1">
            <div id="station_name">${first.bus.name}</div>
            <div id="station_des">
                <p>始发站：${first.station.name}</p>
                <p>终点站：${last.station.name}</p>
                <p id="dnn_ctr528_GCGJ_Path_dayStartEnd" class="startEnd">首末班时间：05:50-18:00</p>
                <p id="dnn_ctr528_GCGJ_Path_dayinterval" class="interval">班次间隔：8~13 分钟</p>

            </div>
            <div id="station_des1">
                <asset:image src="desc.jpg"/>
            </div>
            <br style="clear: both" />
            <div id="stations">

                    <g:hiddenField   id="strlons_id_cheng" name="strlons_id" value="${strlons}" />

                    <g:hiddenField id ="strlats_id" name="strlats_id" value="${strlats}" />

                    <g:hiddenField id="name_id" name="name_id" value="${name}" />


            <ul class="stations clearfix">
                <g:each  status="i" var="result" in="${data}">
                        <li ><span ><b class="no">${i}</b> ${result.station.name}</span></li>
                </g:each>
            </ul>
            </div>
        </div>
        <div id="allmap"></div>
    </div>
</div>
<div id="bottom_bg"></div>

<script type="text/javascript">


    //2013-03-11
    (function () {        //闭包
        function load_script(xyUrl, callback) {
            var head = document.getElementsByTagName('head')[0];
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.src = xyUrl;
            //借鉴了jQuery的script跨域方法
            script.onload = script.onreadystatechange = function () {
                if ((!this.readyState || this.readyState === "loaded" || this.readyState === "complete")) {
                    callback && callback();
                    // Handle memory leak in IE
                    script.onload = script.onreadystatechange = null;
                    if (head && script.parentNode) {
                        head.removeChild(script);
                    }
                }
            };
            // Use insertBefore instead of appendChild  to circumvent an IE6 bug.
            head.insertBefore(script, head.firstChild);
        }
        function translate(point, type, callback, X) {
            var callbackName = 'cbk_' + Math.round(Math.random() * 10000);    //随机函数名
            var xyUrl = "http://api.map.baidu.com/ag/coord/convert?from=" + type + "&to=4&x=" + point.lng + "&y=" + point.lat + "&callback=BMap.Convertor." + callbackName;
            //动态创建script标签
            load_script(xyUrl);
            BMap.Convertor[callbackName] = function (xyResult) {
                delete BMap.Convertor[callbackName];    //调用完需要删除改函数
                var point = new BMap.Point(xyResult.x, xyResult.y);
                callback && callback(point, X);//修改返回参数，添加一个参数X
            }
        }

        function transMore(points, type, callback) {
            var xyUrl = "http://api.map.baidu.com/ag/coord/convert?from=" + type + "&to=4&mode=1";
            var xs = [];
            var ys = [];
            var maxCnt = 20;//每次发送的最大个数
            var send = function () {
                var url = xyUrl + "&x=" + xs.join(",") + "&y=" + ys.join(",") + "&callback=callback";
                //动态创建script标签
                load_script(url);
                xs = [];
                ys = [];
            }
            for (var index in points) {
                if (index % maxCnt == 0 && index != 0) {
                    send();
                }
                xs.push(points[index].lng);
                ys.push(points[index].lat);
                if (index == points.length - 1) {
                    send();
                }
            }

        }



        window.BMap = window.BMap || {};
        BMap.Convertor = {};
        BMap.Convertor.translate = translate;
        BMap.Convertor.transMore = transMore;
    })();


    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(120.535686, 31.864644), 15);
    map.enableScrollWheelZoom();
    var i;
    var markers = [];
    //map.addEventListener("click", function (e) {
    //    alert(e.point.lng + "," + e.point.lat);
    //});

    var strlons = document.getElementById("strlons_id_cheng").value;
    var strlats = document.getElementById("strlats_id").value;
    var strsns = document.getElementById("name_id").value;
    strlons = strlons.substr(0, strlons.length - 1);
    strlats = strlats.substr(0, strlats.length - 1);
    strsns = strsns.substr(0, strsns.length - 1);
    strlons = strlons.split("|");
    strlats = strlats.split("|");
    strsns = strsns.split("|");
    var points = [];
    for (var i = 0; i < strlons.length; i++) {
        points[i] = new BMap.Point(strlons[i], strlats[i]);
    }
    map.centerAndZoom(points[points.length / 2], 15);


    SetMarkPoint();




    ////////////////////////////////////////////////////  添加图标到地图并连线  ///////////////////////////////////////////
    // 全局参数
    var L = 0;//标识是第几个
    var Json = [];//接受转换了的百度坐标
    var hashMap = {   //自定义创建的hasmap 装载转换后的坐标值
        Set: function (key, value) { this[key] = value },
        Get: function (key) { return this[key] },
        Contains: function (key) { return this.Get(key) == null ? false : true },
        Remove: function (key) { delete this[key] }
    }

    //入口函数
    function SetMarkPoint() {

        Json = [];//接受转换了的百度坐标  初始化全局变量
        var K = points.length;//标示符判断最后K、L是否相等
        L = 0;//初始化全局变量
        for (var J = 0; J < points.length; J++) {
            //这里把函数放在外面去调用，因为函数里面是一个异步操作，如果写成内联函数或导致循环值出现不可预知的错误。
            GPSChanges(points[J], J, K);//J为异步获取转换的GPS坐标的标示
        }

    }



    function GPSChanges(point, i, K) {
        var gpsPoint = point;
        //因为转换GPS坐标是异步的，所以循环转换的时候返回来的时候顺序可能不一致，我们可以修改convertor.js的BMap.Convertor.translate()方法，重载一个带返回标示的参数translate()方法。
        // BMap.Convertor.translate(gpsPoint 要转换的GPS坐标,0 为GPS类型的坐标，回调函数，i为返回的标示)
        BMap.Convertor.translate(gpsPoint, 0, function (gpsPoint, Y) {

            var myCompOverlay = new ComplexCustomOverlay(gpsPoint, strsns[i]);
            map.addOverlay(myCompOverlay);//添加点

            hashMap.Set(Y, gpsPoint);//自定义一个全局的javascript hashmap用来装载返回的百度坐标
            L++;
            if (L == K)//判断所有坐标是否已经转换完成
            {
                for (var N = 0; N < K; N++) {
                    Json.push(hashMap.Get(N));//从0开始按顺序获取hashmap的坐标值，装载到Json中
                    hashMap.Remove(N);//清除已经获取的
                }
                for (var j = 0; j < Json.length - 1; j++) {
                    run(j);
                }
            }
        }, i);
    }

    ////////////////////////////////////////////////////////////////// 添加图标到地图并连线  //////////////////////////////////

    window.run = function (i) {
        //map.clearOverlays();                        //清除地图上所有的覆盖物
        var driving = new BMap.DrivingRoute(map);    //创建驾车实例


        driving.search(Json[i], Json[i + 1]);
        driving.setSearchCompleteCallback(function () {
            var pts = driving.getResults().getPlan(0).getRoute(0).getPath();    //通过驾车实例，获得一系列点的数组

            var polyline = new BMap.Polyline(pts, { strokeColor: '#111' });
            map.addOverlay(polyline);

            setTimeout(function () {
                map.setViewport(Json);          //调整到最佳视野
            }, 1000);

        });
    }








    ///////////////////////添加车辆标志///////////////////////////////////////////////////
    var strCarlons = "120.541777000000000|120.543123000000000|120.552805000000000|";
    var strCarlats = "31.834193000000000|31.857562000000000|31.817122000000000|";
    var strCarsns = "苏EH5611|苏EH5617|苏EH5616|";
    strCarlons = strCarlons.substr(0, strCarlons.length - 1);
    strCarlats = strCarlats.substr(0, strCarlats.length - 1);
    strCarsns = strCarsns.substr(0, strCarsns.length - 1);
    strCarlons = strCarlons.split("|");
    strCarlats = strCarlats.split("|");
    strCarsns = strCarsns.split("|");
    var cars = [];
    for (var i = 0; i < strCarlons.length; i++) {
        cars[i] = new BMap.Point(strCarlons[i], strCarlats[i]);
    }

    function callback(xyResults) {
        var xyResult = null;
        for (var index in xyResults) {
            xyResult = xyResults[index];
            if (xyResult.error != 0) { continue; }//出错就直接返回;
            var point1 = new BMap.Point(xyResult.x, xyResult.y);
            var marker2 = new BMap.Marker(point1);
            map.addOverlay(marker2);
            var label = new BMap.Label(strCarsns[index], { offset: new BMap.Size(20, -10) });

            marker2.setLabel(label); //添加百度label
            map.setCenter(point1);// 由于写了这句，每一个被设置的点都是中心点的过程
        }
    }

    setTimeout(function () {
        BMap.Convertor.transMore(cars, 0, callback);        //一秒之后开始进行坐标转换。参数2，表示是从GCJ-02坐标到百度坐标。参数0，表示是从GPS到百度坐标
    }, 1000);


    // 复杂的自定义覆盖物
    function ComplexCustomOverlay(point, text) {
        this._point = point;
        this._text = text;
        this._overText = text;
    }
    ComplexCustomOverlay.prototype = new BMap.Overlay();
    ComplexCustomOverlay.prototype.initialize = function (map) {
        this._map = map;
        var div = this._div = document.createElement("div");
        div.style.position = "absolute";
        div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
        div.style.backgroundColor = "#6BADCA";
        div.style.border = "1px solid #6BADCA";
        div.style.color = "white";
        div.style.height = "18px";
        div.style.padding = "2px";
        div.style.lineHeight = "18px";
        div.style.whiteSpace = "nowrap";
        div.style.MozUserSelect = "none";
        div.style.fontSize = "12px"
        var span = this._span = document.createElement("span");
        div.appendChild(span);
        span.appendChild(document.createTextNode(this._text));
        var that = this;

        var arrow = this._arrow = document.createElement("div");
        arrow.style.background = "url(http://map.baidu.com/fwmap/upload/r/map/fwmap/static/house/images/label.png) no-repeat 0px -20px";
        arrow.style.position = "absolute";
        arrow.style.width = "11px";
        arrow.style.height = "10px";
        arrow.style.top = "22px";
        arrow.style.left = "10px";
        arrow.style.overflow = "hidden";
        div.appendChild(arrow);

        div.onmouseover = function () {
            this.style.backgroundColor = "#EE5D5B";
            this.style.borderColor = "#0000ff";
            this.getElementsByTagName("span")[0].innerHTML = that._overText;
            arrow.style.backgroundPosition = "0px 0px";
        }

        div.onmouseout = function () {
            this.style.backgroundColor = "#6BADCA";
            this.style.borderColor = "#6BADCA";
            this.getElementsByTagName("span")[0].innerHTML = that._text;
            arrow.style.backgroundPosition = "0px -20px";
        }

        map.getPanes().labelPane.appendChild(div);

        return div;
    }
    ComplexCustomOverlay.prototype.draw = function () {
        var map = this._map;
        var pixel = map.pointToOverlayPixel(this._point);
        this._div.style.left = pixel.x - parseInt(this._arrow.style.left) + "px";
        this._div.style.top = pixel.y - 30 + "px";
    }


</script>

</body>
</html>
