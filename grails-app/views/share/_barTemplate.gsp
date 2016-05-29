<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/15 0015
  Time: 下午 9:32
--%>
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="/Bus"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 站点管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/Bus/station/index">站点查找</a></li>
                                <li><a href="/Bus/station/create">添加站点</a></li>
                            </ul>
                        </li>

                        <li class="accordion">
                            <a href="/bus/index"><i class="glyphicon glyphicon-plus"></i><span> 线路管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/Bus/bus">线路查找</a></li>
                                <li><a href="/Bus/bus/create">添加线路</a></li>
                            </ul>
                        </li>

                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 线路-站点管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/Bus/line/index">线路-站点查找</a></li>
                                <li><a href="/Bus/line/create">添加线路-站点</a></li>
                            </ul>
                        </li>

                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 线路-站点管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/Bus/line/index">线路-站点查找</a></li>
                                <li><a href="/Bus/line/create">添加线路-站点</a></li>
                            </ul>
                        </li>

                        %{--<li class="nav-header hidden-md">用户信息管理</li>--}%
                        %{--<li class="accordion">--}%
                            %{--<a href="#"><i class="glyphicon glyphicon-plus"></i><span> 用户管理</span></a>--}%
                            %{--<ul class="nav nav-pills nav-stacked">--}%
                                %{--<li><a href="/Bus/person/index">用户查询</a></li>--}%
                                %{--<li><a href="/Bus/person/create">添加用户</a></li>--}%
                                %{--<li><a href="/Bus/personAuthority">授权查找</a></li>--}%
                                %{--<li><a href="/Bus/personAuthority/create">添加授权</a></li>--}%
                            %{--</ul>--}%
                        %{--</li>--}%

                        %{--<li class="accordion">--}%
                            %{--<a href="#"><i class="glyphicon glyphicon-plus"></i><span> 权限管理</span></a>--}%
                            %{--<ul class="nav nav-pills nav-stacked">--}%
                                %{--<li><a href="/Bus/authority">权限查找</a></li>--}%
                                %{--<li><a href="/Bus/authority/create">添加权限</a></li>--}%
                                %{--<li><a href="/Bus/requestmap">映射查找</a></li>--}%
                                %{--<li><a href="/Bus/requestmap/create">映射创建</a></li>--}%
                            %{--</ul>--}%
                        %{--</li>--}%

                        %{--<li class="accordion">--}%
                            %{--<a href="#"><i class="glyphicon glyphicon-plus"></i><span> 公司管理</span></a>--}%
                            %{--<ul class="nav nav-pills nav-stacked">--}%
                                %{--<li><a href="/Bus/company">公司查找</a></li>--}%
                                %{--<li><a href="/Bus/company/create">公司创建</a></li>--}%
                            %{--</ul>--}%
                        %{--</li>--}%

                    </ul>
                </div>
            </div>
        </div>
