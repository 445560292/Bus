/* Copyright 2015 the original author or authors.
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
package grails.plugin.springsecurity.ui.strategy

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
interface AclStrategy {

	def saveAclClass(Map properties)

	void updateAclClass(Map properties, aclClass)

	void deleteAclClass(aclClass)

	def saveAclEntry(Map properties)

	void updateAclEntry(Map properties, aclEntry)

	void deleteAclEntry(aclEntry)

	def saveAclSid(Map properties)

	void updateAclSid(Map properties, aclSid)

	void deleteAclSid(aclSid)

	def saveAclObjectIdentity(Map properties)

	void updateAclObjectIdentity(Map properties, aclObjectIdentity)

	void deleteAclObjectIdentity(aclObjectIdentity)
}
