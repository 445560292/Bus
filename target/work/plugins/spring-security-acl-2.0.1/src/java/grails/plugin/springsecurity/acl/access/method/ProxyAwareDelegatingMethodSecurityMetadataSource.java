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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * Replacement for DelegatingMethodSecurityMetadataSource which is final.
 * <p/>
 * Makes two changes; unproxies classes, and treats an empty return value from
 * <code>MethodSecurityMetadataSource.getAttributes()</code> as equivalent to a
 * <code>null</code> return since an empty return stops the loop and another
 * source might have attributes.
 *
 * @author Ben Alex
 * @author Luke Taylor
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
public class ProxyAwareDelegatingMethodSecurityMetadataSource
       extends AbstractMethodSecurityMetadataSource
       implements InitializingBean {

	protected final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();

	protected List<MethodSecurityMetadataSource> methodSecurityMetadataSources;
	protected final Map<DefaultCacheKey, Collection<ConfigAttribute>> cache =
		new HashMap<DefaultCacheKey, Collection<ConfigAttribute>>();

	public Collection<ConfigAttribute> getAttributes(final Method m, final Class<?> tc) {

		Method method = ProxyUtils.unproxy(m);
		Class<?> targetClass = ProxyUtils.unproxy(tc);

		DefaultCacheKey cacheKey = new DefaultCacheKey(method, targetClass);
		synchronized (cache) {
			Collection<ConfigAttribute> cached = cache.get(cacheKey);
			// Check for canonical value indicating there is no config attribute,
			if (cached == NULL_CONFIG_ATTRIBUTE) {
				return null;
			}

			if (cached != null) {
				return cached;
			}

			// No cached value, so query the sources to find a result
			Collection<ConfigAttribute> attributes = null;
			for (MethodSecurityMetadataSource s : methodSecurityMetadataSources) {
				attributes = s.getAttributes(method, targetClass);
				if (attributes != null && !attributes.isEmpty()) {
					break;
				}
			}

			// Put it in the cache.
			if (attributes == null) {
				cache.put(cacheKey, NULL_CONFIG_ATTRIBUTE);
				return null;
			}

			if (logger.isDebugEnabled()) {
				logger.debug("Adding security method [" + cacheKey + "] with attributes " + attributes);
			}

			cache.put(cacheKey, attributes);

			return attributes;
		}
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> set = new HashSet<ConfigAttribute>();
		for (MethodSecurityMetadataSource s : methodSecurityMetadataSources) {
			Collection<ConfigAttribute> attrs = s.getAllConfigAttributes();
			if (attrs != null) {
				set.addAll(attrs);
			}
		}
		return set;
	}

	/**
	 * Dependency injection for the sources.
	 * @param sources  the sources
	 */
	public void setMethodSecurityMetadataSources(final List<MethodSecurityMetadataSource> sources) {
		methodSecurityMetadataSources = sources;
	}

	public void afterPropertiesSet() {
		Assert.notEmpty(methodSecurityMetadataSources, "A list of MethodSecurityMetadataSources is required");
	}

	static class DefaultCacheKey {
		protected final Method method;
		protected final Class<?> targetClass;

		DefaultCacheKey(final Method m, final Class<?> target) {
			method = m;
			targetClass = target;
		}

		@Override
		public boolean equals(final Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof DefaultCacheKey)) {
				return false;
			}
			DefaultCacheKey otherKey = (DefaultCacheKey) other;
			return (method.equals(otherKey.method) &&
					ObjectUtils.nullSafeEquals(targetClass, otherKey.targetClass));
		}

		@Override
		public int hashCode() {
			return method.hashCode() * 21 + (targetClass != null ? targetClass.hashCode() : 0);
		}

		@Override
		public String toString() {
			return "CacheKey[" + (targetClass == null ? "-" : targetClass.getName()) + "; " + method + "]";
		}
	}
}
