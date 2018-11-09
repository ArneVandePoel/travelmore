package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/locaties")
public class LocatieRestService {

    @Inject
    private LocatieService locatieService;

    // Alle locaties opvragen
    // travelmore/rest/locaties/
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Locatie> getAllLocaties() {
        return locatieService.findAllLocaties();
    }

    // Een locatie met id {id} opvragen
    // travelmore/rest/locaties/{id}
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Locatie getLocatieById(@PathParam("id") int id) {
        return locatieService.findLocatieById(id);
    }

    // Een locatie toevoegen
    // travelmore/rest/locaties/
    @POST
    @Path("")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addLocatie(Locatie locatie) {
        if (locatieService.findLocatieById(locatie.getId()) != null) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("locatie id should not be set.").build();
        }

        locatieService.insert(locatie);
        return Response.status(Response.Status.CREATED).entity(locatie).build();
    }

    // Een locatie verwijderen
    // travelmore/rest/locaties/{id}
    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") int id) {
        locatieService.deleteById(id);
    }
}