package org.octocode.booking.data;

import org.octocode.booking.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PersonDataRepository extends PersonRepository, Repository<Person, Integer> {
		
		@Override
	    @Query("SELECT DISTINCT person FROM Person person WHERE person.lastName LIKE :lastName%")
	    public Collection<Person> findByLastName(@Param("lastName") String lastName);
		
		@Override
		@Query("SELECT person FROM Person person WHERE person.id =:id")
	    public Person findById(@Param("id") int id);
}
