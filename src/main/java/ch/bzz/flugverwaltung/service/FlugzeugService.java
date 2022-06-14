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

/**
 * services for reading, adding, changing and deleting flugzeugs
 */
@Path("flugzeug")
public class FlugzeugService {
    /**
     * reads a list of all flugzeugs
     *
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugzeugs() {
        List<Flugzeug> flugzeugList = DataHandler.readAllFlugzeugs();
        return Response
                .status(200)
                .entity(flugzeugList)
                .build();
    }

    /**
     * reads a flugzeug by UUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlugzeug(
            @QueryParam("uuid") String flugzeugUUID
    ){
        int httpStatus = 200;
        Flugzeug flugzeug = DataHandler.readFlugzeugByUUID(flugzeugUUID);
        if (flugzeug == null){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(flugzeug)
                .build();
    }
}
