<html>
	<head>
		<meta name="layout" content="${layoutUi}"/>
		<s2ui:title messageCode='spring.security.ui.role.search'/>
	</head>
	<body>
		<div>
			<s2ui:formContainer type='search' beanType='role' height='300'>
				<s2ui:searchForm colspan='2'>
					<tr>
						<td><g:message code='role.authority.label' default='Authority'/>:</td>
						<td><g:textField name='authority' class='textField' size='50' maxlength='255' autocomplete='off' value='${authority}'/></td>
					</tr>
				</s2ui:searchForm>
			</s2ui:formContainer>
			<g:if test='${searched}'>
			<div class="list">
			<table>
				<thead>
					<tr>
						<s2ui:sortableColumn property='authority' titleDefault='Authority'/>
					</tr>
				</thead>
				<tbody>
				<g:each in='${results}' status='i' var='role'>
					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
						<td><g:link action='edit' id='${role.id}'>${uiPropertiesStrategy.getProperty(role, 'authority')}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			</div>
			<s2ui:paginate total='${totalCount}'/>
			</g:if>
		</div>
		<s2ui:ajaxSearch paramName='authority' minLength='2'/>
	</body>
</html>
