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
                        <g:form url="[resource:busInstance, action:'update']" method="PUT" >
                            <g:hiddenField name="version" value="${busInstance?.version}" />
                            <fieldset class="form">
                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'company', 'error')} required">
                                    <label for="company">
                                        <g:message code="bus.company.label" default="Company" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <g:select id="company" name="company.id" from="${com.bus.Company.list()}" optionKey="id" required="" value="${busInstance?.company?.id}" class="many-to-one"/>

                                </div>
                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'endTime', 'error')} required">
                                    <label for="endTime">
                                        <g:message code="bus.endTime.label" default="End Time" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <g:datePicker name="endTime" precision="day"  value="${busInstance?.endTime}"  />

                                </div>

                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'isCircle', 'error')} ">
                                    <label for="isCircle">
                                        <g:message code="bus.isCircle.label" default="Is Circle" />

                                    </label>
                                    <g:checkBox name="isCircle" value="${busInstance?.isCircle}" />

                                </div>

                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'name', 'error')} required">
                                    <label for="name">
                                        <g:message code="bus.name.label" default="Name" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <g:textField name="name" required="" value="${busInstance?.name}"/>

                                </div>

                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'ptPrice', 'error')} required">
                                    <label for="ptPrice">
                                        <g:message code="bus.ptPrice.label" default="Pt Price" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <g:field name="ptPrice" value="${fieldValue(bean: busInstance, field: 'ptPrice')}" required=""/>

                                </div>

                                <div class="fieldcontain ${hasErrors(bean: busInstance, field: 'startTime', 'error')} required">
                                    <label for="startTime">
                                        <g:message code="bus.startTime.label" default="Start Time" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <g:datePicker name="startTime" precision="day"  value="${busInstance?.startTime}"  />

                                </div>
                            </fieldset>
                            <fieldset class="buttons">
                                <g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                            </fieldset>
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
