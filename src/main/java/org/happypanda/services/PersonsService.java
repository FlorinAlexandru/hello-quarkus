package org.happypanda.services;

import org.happypanda.models.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonsService {

    @Inject
    private EntityManager em;

    public List<Person> getPersons() {
        List<Person> persons = em.createQuery("from Person", Person.class).getResultList();
        return persons;
    }

    public Person addPerson(Person person) {
        Person entity =  new Person(person.getFirstName(), person.getLastName());
        em.persist(entity);
        em.flush();
        return entity;
    }
}