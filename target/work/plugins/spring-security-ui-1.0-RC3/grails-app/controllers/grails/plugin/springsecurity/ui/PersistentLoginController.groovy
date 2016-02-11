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

import grails.plugin.springsecurity.ui.strategy.PersistentLoginStrategy

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class PersistentLoginController extends AbstractS2UiDomainController {

	/** Dependency injection for the 'uiPersistentLoginStrategy' bean. */
	PersistentLoginStrategy uiPersistentLoginStrategy

	def update() {
		doUpdate { persistentLogin ->
			uiPersistentLoginStrategy.updatePersistentLogin params, persistentLogin
		}
	}

	def delete() {
		tryDelete { persistentLogin ->
			uiPersistentLoginStrategy.deletePersistentLogin persistentLogin
		}
	}

	def search() {
		if (!isSearch()) {
			// show the form
			return
		}

		def results = doSearch { ->
			like 'series', delegate
			like 'token', delegate
			like 'username', delegate
		}

		renderSearch([results: results, totalCount: results.totalCount],
		             'series', 'token', 'username')
	}

	protected Class<?> getClazz() { PersistentLogin }
	protected String getClassLabelCode() { 'persistentLogin.label' }
	protected Map model(persistentLogin, String action) {
		[persistentLogin: persistentLogin]
	}

	protected Class<?> PersistentLogin

	void afterPropertiesSet() {
		super.afterPropertiesSet()
		if (conf.rememberMe.persistentToken.domainClassName) {
			PersistentLogin = getDomainClassClass(conf.rememberMe.persistentToken.domainClassName)
		}
	}
}
