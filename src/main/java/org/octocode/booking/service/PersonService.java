package org.octocode.booking.service;

import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Dmitriy Guskov
 */
@Service
public class PersonService {
    @Resource
    private PersonRepository personRepository;

    @Transactional
    public Person save(Integer id) {
        Person person = personRepository.findById(id);
        person.setCity("OREN");
        return person;
    }
}
