package org.octocode.booking.data;

import org.octocode.booking.model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PersonDataRepository extends PersonRepository, Repository<Person, Integer> {
    @Override
    @Query("SELECT DISTINCT person FROM Person person WHERE person.lastName LIKE :lastName%")
    public Collection<Person> findByLastName(@Param("lastName") String lastName);

    @Override
    @Query("SELECT person FROM Person person WHERE person.id =:id")
    public Person findById(@Param("id") int id);

    @Override
    @Query("SELECT person FROM Person person WHERE person.username =:username")
    public Person findByUsername(@Param("username") String user);

    @Override
    @Query("select person from Person person")
    public List<Person> findAll();

    //@Override
    //@Query("UPDATE person from Person person")
    //public void save(Person person);
}
