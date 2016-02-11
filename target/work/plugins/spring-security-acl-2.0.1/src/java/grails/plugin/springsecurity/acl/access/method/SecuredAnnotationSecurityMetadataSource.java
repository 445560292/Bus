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
package grails.plugin.springsecurity.acl.access.method;

import grails.plugin.springsecurity.acl.util.ProxyUtils;
import grails.plugin.springsecurity.annotation.Secured;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.AbstractFallbackMethodSecurityMetadataSource;

/**
 * Based on the Spring Security class of the same name but supports the plugin's @Secured annotation
 * which can be applied on fields to support annotated controller actions.
 *
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
public class SecuredAnnotationSecurityMetadataSource extends AbstractFallbackMethodSecurityMetadataSource {

	protected Collection<String> serviceClassNames;

	@Override
	protected Collection<ConfigAttribute> findAttributes(final Class<?> clazz) {

		Class<?> actualClass = ProxyUtils.unproxy(clazz);

		if (!isService(actualClass)) {
			return null;
		}

		return processAnnotation(actualClass.getAnnotation(Secured.class));
	}

	@Override
	protected Collection<ConfigAttribute> findAttributes(final Method method, final Class<?> targetClass) {
		Method actualMethod = ProxyUtils.unproxy(method);

		if (!isService(actualMethod.getDeclaringClass())) {
			return null;
		}

		return processAnnotation(actualMethod.getAnnotation(Secured.class));
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	protected List<ConfigAttribute> processAnnotation(final Annotation a) {
		if (!(a instanceof Secured)) {
			return null;
		}

		String[] attributeTokens = ((Secured)a).value();
		List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>(attributeTokens.length);
		for(String token : attributeTokens) {
			attributes.add(new SecurityConfig(token));
		}

		return attributes;
	}

	protected boolean isService(final Class<?> clazz) {
		for (String name : serviceClassNames) {
			if (name.equals(clazz.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Dependency injection for current service class names.
	 * @param names the names
	 */
	public void setServiceClassNames(final Collection<String> names) {
		serviceClassNames = names;
	}
}
