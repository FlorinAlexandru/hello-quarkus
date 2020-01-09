package org.happypanda;


import org.happypanda.models.Person;
import org.happypanda.services.PersonsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsResource.class);

    @Inject
    private PersonsService personsService;

    @GET
    @Path("/persons")
    public List<Person> getAllPersons() {
        List<Person> persons = personsService.getPersons();
        LOGGER.info(persons.toString());
        return persons;
    }

    @POST
    @Path("/person")
    @Transactional
    public Person addPerson(Person person) {
        Person personEntity = personsService.addPerson(person);
        LOGGER.info(personEntity.toString());
        return personEntity;
    }
}

