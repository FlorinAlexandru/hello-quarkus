package org.happypanda;

import org.happypanda.services.GreetingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/api/v1")
public class GreetingsResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsResource.class);

    @Inject
    GreetingsService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greetings")
    public String greeting(@QueryParam("name")  String name) {
        LOGGER.info(name);
        return service.greetings(name);
    }
}