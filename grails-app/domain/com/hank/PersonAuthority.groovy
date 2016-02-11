package com.hank

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class PersonAuthority implements Serializable {

	private static final long serialVersionUID = 1

	Person person
	Authority authority

	PersonAuthority(Person u, Authority r) {
		this()
		person = u
		authority = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof PersonAuthority)) {
			return false
		}

		other.person?.id == person?.id && other.authority?.id == authority?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (person) builder.append(person.id)
		if (authority) builder.append(authority.id)
		builder.toHashCode()
	}

	static PersonAuthority get(long personId, long authorityId) {
		criteriaFor(personId, authorityId).get()
	}

	static boolean exists(long personId, long authorityId) {
		criteriaFor(personId, authorityId).count()
	}

	private static DetachedCriteria criteriaFor(long personId, long authorityId) {
		PersonAuthority.where {
			person == Person.load(personId) &&
			authority == Authority.load(authorityId)
		}
	}

	static PersonAuthority create(Person person, Authority authority, boolean flush = false) {
		def instance = new PersonAuthority(person: person, authority: authority)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Person u, Authority r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = PersonAuthority.where { person == u && authority == r }.deleteAll()

		if (flush) { PersonAuthority.withSession { it.flush() } }

		rowCount
	}

	static void removeAll(Person u, boolean flush = false) {
		if (u == null) return

		PersonAuthority.where { person == u }.deleteAll()

		if (flush) { PersonAuthority.withSession { it.flush() } }
	}

	static void removeAll(Authority r, boolean flush = false) {
		if (r == null) return

		PersonAuthority.where { authority == r }.deleteAll()

		if (flush) { PersonAuthority.withSession { it.flush() } }
	}

	static constraints = {
		authority validator: { Authority r, PersonAuthority ur ->
			if (ur.person == null || ur.person.id == null) return
			boolean existing = false
			PersonAuthority.withNewSession {
				existing = PersonAuthority.exists(ur.person.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['person', 'authority']
		version false
	}
}
