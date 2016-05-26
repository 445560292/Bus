<%@ page import="com.bus.Bus" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<g:set var="entityName" value="${message(code: 'bus.label', default: 'Bus')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
	<g:render template="/share/cssTemplate" />

</head>

<body>
<g:render template="/share/topbarTemplate"></g:render>
<div class="ch-container">
	<div class="row">
		<g:render template="/share/barTemplate" />

		<noscript>
			<div class="alert alert-block col-md-12">
				<h4 class="alert-heading">Warning!</h4>

				<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
					enabled to use this site.</p>
			</div>
		</noscript>
		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li>
						<a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
					</li>
					<li>
						<a href="#">bus</a>
					</li>
				</ul>
			</div>
			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2><i class="glyphicon glyphicon-edit"></i> Form Elements</h2>

							<div class="box-icon">
								<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a>
								<a href="#" class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
							</div>
						</div>
					</div>
					<div class="box-content">
						<g:form url="[resource:stationInstance, action:'save']" role="form" >
							<div class="form-group">
								<label for="name">Station name</label>
								<g:textField name="name" id="name" required="" class="form-control"  placeholder="Enter station name" value="${stationInstance?.name}"/>
							</div>

							<div class="form-group">
								<label for="bus">Bus</label
								<g:select id="bus" name="bus.id" from="${com.bus.Bus.list()}"  optionKey="id" required=""
										  value="${lineInstance?.bus?.id}" class="many-to-one form-control"/>
							</div>
							<div class="form-group">
								<label for="form">From</label>
							</label>
							<g:select id="form" name="form.id" from="${com.bus.Station.list()}" optionKey="id"
									  required="" value="${lineInstance?.form?.id}" class="many-to-one form-control"/>
							</div>

							<div class="form-group">
							<label for="start">
							    start
							</label>
							<g:select id="start" name="start.id" from="${com.bus.Station.list()}" optionKey="id" required="" value="${lineInstance?.start?.id}" class="many-to-one form-control"/>
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</g:form>
					</div>
				</div>
				<!--/span-->

			</div><!--/row-->

		<!-- content ends -->
		</div>
	</div>

</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	 aria-hidden="true">

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
			</div>
		</div>
	</div>
</div>

<footer class="row">
	<p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
	Usman</a> 2012 - 2015</p>

	<p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
			href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
</footer>

</div><!--/.fluid-container-->
<asset:javascript src="application.js"/>
</body>
</html>
