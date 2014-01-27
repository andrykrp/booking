package org.octocode.booking.data;

import org.octocode.booking.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query("SELECT DISTINCT person FROM Person person WHERE person.lastName LIKE :lastName%")
    public Collection<Person> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT person FROM Person person WHERE person.id =:id")
    public Person findById(@Param("id") int id);

    Person findByUsername(String user) throws DataAccessException;

//    @Query("select person from Person person")
//    public List<Person> findAll();
}
