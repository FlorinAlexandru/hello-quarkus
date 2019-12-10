package org.happypanda;


import org.happypanda.models.Person;
import org.happypanda.services.PersonsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1")
public class PersonsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsResource.class);

    @Inject
    private PersonsService personsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons")
    public List<Person> getAllPersons() {
        List<Person> persons = personsService.getPersons();
        LOGGER.info(persons.toString());
        return persons;
    }
}

