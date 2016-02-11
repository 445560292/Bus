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

import grails.plugin.springsecurity.ui.strategy.RegistrationCodeStrategy

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class RegistrationCodeController extends AbstractS2UiDomainController {

	/** Dependency injection for the 'uiRegistrationCodeStrategy' bean. */
	RegistrationCodeStrategy uiRegistrationCodeStrategy

	def update() {
		doUpdate { registrationCode ->
			uiRegistrationCodeStrategy.updateRegistrationCode params, registrationCode
		}
	}

	def delete() {
		tryDelete { registrationCode ->
			uiRegistrationCodeStrategy.deleteRegistrationCode registrationCode
		}
	}

	def search() {
		if (!isSearch()) {
			// show the form
			return
		}

		def results = doSearch { ->
			like 'token', delegate
			like 'username', delegate
		}

		renderSearch([results: results, totalCount: results.totalCount],
		             'token', 'username')
	}

	protected Class<?> getClazz() { RegistrationCode }
	protected String getClassLabelCode() { 'registrationCode.label' }
	protected String getSimpleClassName() { 'RegistrationCode' }
	protected Map model(registrationCode, String action) {
		[registrationCode: registrationCode]
	}
}
