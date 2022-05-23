package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Flugzeug;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("flugzeug")
public class FlugzeugService {
    /**
     * reads a list of all Passengers
     *
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugzeugs() {
        List<Flugzeug> flugzeugList = DataHandler.getInstance().readAllFlugzeugs();
        return Response
                .status(200)
                .entity(flugzeugList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlugzeug(
            @QueryParam("uuid") String flugzeugUUID
    ){
        Flugzeug flugzeug = DataHandler.getInstance().readFlugzeugByUUID(flugzeugUUID);
        return Response
                .status(200)
                .entity(flugzeug)
                .build();
    }
}