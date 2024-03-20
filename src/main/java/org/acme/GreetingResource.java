package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.acme.sao.GreetingService;
import org.acme.utils.Constants;

@Path(Constants.PATH)
public class GreetingResource {

    private final GreetingService service;

    @Inject
    GreetingResource(final GreetingService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{"+ Constants.NAME_PATH_VAR + "}")
    public String greeting(@PathParam(Constants.NAME_PATH_VAR) final String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy Imagine that a hot swappable java dev..";
    }
}
