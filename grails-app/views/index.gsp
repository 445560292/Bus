<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xAtEtZe8LeRKoqomjAEp8UHDKppRGYWw"></script>
		<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
		<title>Welcome to Grails</title>
		<asset:javascript src="application.js"/>
		<style>
		.ui-autocomplete-category {
			font-weight: bold;
			padding: .2em .4em;
			margin: .8em 0 .2em;
			line-height: 1.5;
			background-color: #0B90C4;
		}
		</style>
		<script type="text/javascript">
			// Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9

			function OnInput1 (event) {
//3.$.ajax拼接url的异步请求
				var yz=$.ajax({
					type:'post',
					url:'/Bus/station/search?name=' + $( "#searchByBus1" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){

						$( "#searchByBus1" ).autocomplete({
							source: data
						});
//						$( "#searchByBus1" ).typeahead(
//								{
//									source: data
//								});
					},
					error:function(){}
				});
			}

			function OnInput2 (event) {
//3.$.ajax拼接url的异步请求
				var yz=$.ajax({
					type:'post',
					url:'/Bus/station/search?name=' + $( "#searchByBus2" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						$( "#searchByBus2" ).autocomplete({
							source: data
						});
					},
					error:function(){}
				});
			}

			function OnInput3 (event) {
//3.$.ajax拼接url的异步请求
				var yz=$.ajax({
					type:'post',
					url:'/Bus/station/search?name=' + $( "#searchByBus3" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						$( "#searchByBus3" ).autocomplete({
							source: data
						});
					},
					error:function(){}
				});
			}

			function OnInput4 (event) {
//3.$.ajax拼接url的异步请求
				var yz=$.ajax({
					type:'post',
					url:'/Bus/station/search?name=' + $( "#searchByBus4" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						$( "#searchByBus4" ).autocomplete({
							source: data
						});
					},
					error:function(){}
				});
			}

			function OnInput5 (event) {
//3.$.ajax拼接url的异步请求

				var yz=$.ajax({
					type:'post',
					url:'/Bus/bus/searchByName?name=' + $( "#searchByBus5" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						$( "#searchByBus5" ).autocomplete({
							source: data
						});
					},
					error:function(){}
				});
			}
			function OnInput6 (event) {
//3.$.ajax拼接url的异步请求

				var yz=$.ajax({
					type:'post',
					url:'/Bus/search/searchLocation?name=' + $( "#searchLocation" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						$( "#searchLocation" ).autocomplete({
							source: data
						});
					},
					error:function(){}
				});
			}
			function submitSearch (event) {
//3.$.ajax拼接url的异步请求

				var yz=$.ajax({
					type:'post',
					url:'/Bus/search/searchStationByLocation?name=' + $( "#searchLocation" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						var trs = "";
						$.each(data,function(n,value) {
							trs += " " + value.name;
						});
						$('#modal-body').text(trs +" 等几个站点")
						$('#myModal').modal('show')
					},
					error:function(){

					}
				});


			}


			function submitSearchLineByLocation (event) {
//3.$.ajax拼接url的异步请求

				var yz=$.ajax({
					type:'post',
					url:'/Bus/search/searchLineByStation?name=' + $( "#searchLineByLoacation" ).val(),
					data:{},
					cache:false,
					dataType:'json',
					success:function(data){
						var trs = "";
						$.each(data,function(n,value) {
							trs += " " + value;
						});
						$('#modal-body').text(trs +" 等几个线路")
						$('#myModal').modal('show')
					},
					error:function(){

					}
				});


			}


		</script>
	</head>
	<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: #5bc0de">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#" style="color: #080808; font-weight: 900;font-size: x-large">公交系统查询</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" action='/Bus/j_spring_security_check' method="post">
					<div class="form-group">
						<input type="text"  class="form-control" placeholder="Username" name='j_username' id='username'>
					</div>
					<div class="form-group">
						<input type="password" name = 'j_password' id="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div><!--/.navbar-collapse -->
		</div>
	</nav>

	<div id="myCarousel" class="carousel slide" style="margin-top: 20px">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="images/430642_111954000_2.jpg" alt="First slide" style=" margin: 0 auto; height: 300px; width: 400px">
				<div class="carousel-caption">标题 1</div>
			</div>
			<div class="item">
				<img src="images/20140626080129_75157.jpg" alt="Second slide" style=" margin: 0 auto; height: 300px; width: 400px">
				<div class="carousel-caption">标题 2</div>
			</div>
			<div class="item">
				<img src="images/2496884_072100005_2.jpg" alt="Third slide" style=" margin: 0 auto; height: 300px; width: 400px">
				<div class="carousel-caption">标题 3</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel"
		   data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel"
		   data-slide="next">&rsaquo;</a>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>车次查询</h2>
				<form class="form-horizontal"   action='/Bus/search/searchByBus' method="post">
						<div class="input-group">
							<input id="searchByBus5" oninput="OnInput5()"  type="text" class="form-control" name="name" placeholder="输入线路名称....">
							<button class="btn btn-default" type="submit" style="margin-top: 10px">查询</button>
						</div>
				</form><!-- /input-group >
				</div><!-- /.row -->

			</div>

		<div class="col-md-4">
			<form class="form-horizontal" action='/Bus/search/searchByOneTransfer' method="post">
				<h2>线路查询-少换乘</h2>
				<div class="form-group" style="margin-bottom: 10px;margin-left: 10px">
					<label>
						<input type="checkbox", name="map",id="map" value="map"> 百度地图
					</label>
				</div>
				<div class="input-group  ">
					<input type="hidden", name="lessTime", value="false">
					<input type="text" id="searchByBus1" autocomplete=off oninput="OnInput1()" name="start" class="form-control" placeholder="输入起点地点....">
					<input type="text" id="searchByBus2" oninput="OnInput2()" name="des" class="form-control" placeholder="输入目的地点...." style="margin-top: 10px">
					<button class="btn btn-default" type="submit" style="margin-top: 10px">查询</button>
				</div>
			</form>
		</div>

		<div class="col-md-4">
			<form class="form-horizontal" action='/Bus/search/search' method="post">
				<h2>线路查询-路程短</h2>

				<div class="input-group">
					<input type="hidden", name="lessTime", value="true">
					<input type="text" id="searchByBus3" oninput="OnInput3()" name="start" class="form-control" placeholder="输入起点地点....">
					<input type="text" id="searchByBus4" oninput="OnInput4()" name="des" class="form-control" placeholder="输入目的地点...." style="margin-top: 10px">
					<button class="btn btn-default" type="submit" style="margin-top: 10px">查询</button>
				</div>
			</form>
		</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h2>附近站点查询</h2>
				<form class="form-horizontal">
					<div class="input-group">
						<input id="searchLocation" oninput="OnInput6()"  type="text" class="form-control" name="name" placeholder="输入地点名称....">
						<button class="btn btn-default" type="button"  onclick="submitSearch()" style="margin-top: 10px">查询</button>
					</div>
				</form><!-- /input-group >
				</div><!-- /.row -->
			</div>


			<div class="col-md-4">
				<h2>站点 - 线路 查询</h2>
				<form class="form-horizontal">
					<div class="input-group">
						<input id="searchLineByLoacation" oninput="OnInput7()"  type="text" class="form-control" name="name" placeholder="输入地点名称....">
						<button class="btn btn-default" type="button"  onclick="submitSearchLineByLocation()" style="margin-top: 10px">查询</button>
					</div>
				</form><!-- /input-group >
				</div><!-- /.row -->
			</div>
		</div>
		<hr>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			 aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>公交站点</h3>
					</div>
					<div class="modal-body">
						<p id = "modal-body">Here settings can be configured...</p>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<div><p style="margin:0 auto; text-align: center"> &copy; Company 2016</p></div>
		</footer>
	</div> <!-- /container -->

	%{--<div style="width:600px;height:340px;border:1px solid gray;float:left;" id="container-map"></div>--}%
	%{--<div style="width:300px;height:340px;border:1px solid gray;border-left:0;float:left;" id="panel"></div>--}%

	<script type="text/javascript">
		var map = new BMap.Map("container-map");
//		var yz=$.ajax({
//			type:'get',
//			url:'/Bus/station/getAllStation' ,
//			data:{},
//			cache:false,
//			dataType:'json',
//			success:function(data){
//
//				$.each(data,function(item,value){
//					if(value.strlats !=''){
//						var mPoint = new BMap.Point(value.strlons, value.strlats);
//						map.centerAndZoom(mPoint, 16);
//						map.enableScrollWheelZoom();        //启用滚轮缩放
//
//						var mOption = {
//							poiRadius : 500,           //半径为1000米内的POI,默认100米
//							numPois : 12                //列举出50个POI,默认10个
//						}
//
//						var myGeo = new BMap.Geocoder();        //创建地址解析实例
//						map.addOverlay(new BMap.Circle(mPoint,500));        //添加一个圆形覆盖物
//						myGeo.getLocation(mPoint,
//								function mCallback(rs){
//									var allPois = rs.surroundingPois;       //获取全部POI（该点半径为100米内有6个POI点）
//									for(i=0;i<allPois.length;++i){
//										document.getElementById("panel").innerHTML += value.name + ":" + allPois[i].title+"/";
//										map.addOverlay(new BMap.Marker(allPois[i].point));
//									}
//								},mOption
//						);
//
//					}
//
//				})
//			},
//			error:function(msg){
//				alert(msg);
//			}
//		});




	</script>

	</body>

</html>

