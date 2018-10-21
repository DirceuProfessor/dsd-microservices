package br.unip.dsd_microservice.resource;


import com.codahale.metrics.annotation.Timed;

import br.unip.dsd_microservice.modelo.ExemploJson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/dsd-microservice")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceExemplo{
    private final String template;
    private final String nomePadrao;
    private final AtomicLong counter;

    public ResourceExemplo(String template, String defaultName) {
        this.template = template;
        this.nomePadrao = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public ExemploJson digaOla(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(nomePadrao));
        return new ExemploJson(counter.incrementAndGet(), value);
    }
}