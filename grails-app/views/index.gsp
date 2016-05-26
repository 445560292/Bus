<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xAtEtZe8LeRKoqomjAEp8UHDKppRGYWw"></script>
		<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
		<title>Welcome to Grails</title>
		<asset:javascript src="application.js"/>

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

						$( "#searchByBus1" ).typeahead(
								{
									source: data
								});
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
						$( "#searchByBus2" ).typeahead(
								{
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
						$( "#searchByBus3" ).typeahead(
								{
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
						$( "#searchByBus4" ).typeahead(
								{
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
						$( "#searchByBus5" ).typeahead(
								{
									source: data
								});
					},
					error:function(){}
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
		<hr>
		<footer>
			<div><p style="margin:0 auto; text-align: center"> &copy; Company 2016</p></div>
		</footer>
	</div> <!-- /container -->
	</body>
</html>

