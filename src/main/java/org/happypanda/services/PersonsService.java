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
}