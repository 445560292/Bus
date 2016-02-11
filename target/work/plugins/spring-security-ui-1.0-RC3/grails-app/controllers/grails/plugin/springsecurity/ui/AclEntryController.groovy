/* Copyright 2009-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.springsecurity.ui

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class AclEntryController extends AbstractS2UiDomainController {

	def aclPermissionFactory

	def create() {
		params.granting = true
		super.create()
	}

	def save() {
		doSave uiAclStrategy.saveAclEntry(params)
	}

	def update() {
		doUpdate { aclEntry ->
			uiAclStrategy.updateAclEntry params, aclEntry
		}
	}

	def delete() {
		tryDelete { aclEntry ->
			uiAclStrategy.deleteAclEntry aclEntry
		}
	}

	def search() {
		if (!isSearch('aclClass.id', 'aclObjectIdentity.id', 'sid.id')) {
			// show the form
			return [sids: AclSid.list()]
		}

		Closure projection
		Long classId = params.long('aclClass.id')
		if (classId) {
			// special case for external search
			projection = buildProjection('aclObjectIdentity.aclClass', 'eq', ['id', classId])
		}

		def results = doSearch(projection) { ->

			eqInt 'aceOrder', delegate
			eqInt 'mask', delegate

			eqLongId 'aclObjectIdentity', delegate
			eqLongId 'sid', delegate

			eqBoolean 'auditFailure', delegate
			eqBoolean 'auditSuccess', delegate
			eqBoolean 'granting', delegate
		}

		renderSearch([results: results, totalCount: results.totalCount,
		              sids: AclSid.list(), permissionFactory: aclPermissionFactory],
		             'aceOrder', 'aclClass.id', 'aclObjectIdentity.id', 'auditFailure',
						 'auditSuccess', 'granting', 'mask', 'sid.id')
	}

	protected Class<?> getClazz() { AclEntry }
	protected String getClassLabelCode() { 'aclEntry.label' }
	protected String getSimpleClassName() { 'AclEntry' }
	protected Map model(aclEntry, String action) {
		[aclEntry: aclEntry, sids: AclSid.list()]
	}

	protected Class<?> AclEntry

	void afterPropertiesSet() {
		super.afterPropertiesSet()
		AclEntry = getDomainClassClass('grails.plugin.springsecurity.acl.AclEntry')
	}
}
