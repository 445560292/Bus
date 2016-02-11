<html>
	<head>
		<meta name="layout" content="${layoutUi}"/>
		<title><g:message code='spring.security.ui.menu.securityInfo.filterChains'/></title>
	</head>
	<body>
		<s2ui:securityInfoTable type='filterChains' items='${filterChainMap}' headerCodes='pattern,filters'>
			<td>${it.key}</td>
			<td>
				<g:if test='${it.value}'>
				<ul>
				<g:each var='filter' in='${it.value}'>
					<li>${filter.getClass().name}</li>
				</g:each>
				</ul>
				</g:if>
				<g:else>
				<i><g:message code='spring.security.ui.info.filterChains.none'/></i>
				</g:else>
			</td>
		</s2ui:securityInfoTable>
	</body>
</html>
