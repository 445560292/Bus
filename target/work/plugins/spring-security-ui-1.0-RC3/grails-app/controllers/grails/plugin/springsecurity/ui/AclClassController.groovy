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
class AclClassController extends AbstractS2UiDomainController {

	def save() {
		doSave uiAclStrategy.saveAclClass(params)
	}

	def update() {
		doUpdate { aclClass ->
			uiAclStrategy.updateAclClass params, aclClass
		}
	}

	def delete() {
		tryDelete { aclClass ->
			uiAclStrategy.deleteAclClass aclClass
		}
	}

	def search() {
		if (!isSearch()) {
			// show the form
			return
		}

		def results = doSearch { ->
			like 'className', delegate
		}

		renderSearch([results: results, totalCount: results.totalCount], 'className')
	}

	protected Class<?> getClazz() { AclClass }
	protected String getClassLabelCode() { 'aclClass.label' }
	protected String getSimpleClassName() { 'AclClass' }
	protected Map model(aclClass, String action) {
		[aclClass: aclClass]
	}
}
