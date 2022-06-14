package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Passagier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * services for reading, adding, changing and deleting flugs
 */
@Path("flug")
public class FlugService {
    /**
     * reads a list of all flugs
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugs(){
        List<Flug> flugList = DataHandler.readAllFlugs();
        return Response
                .status(200)
                .entity(flugList)
                .build();
    }

    /**
     * reads a flug by UUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlug(
            @QueryParam("uuid") String flugUUID
    ){
        int httpStatus = 200;
        Flug flug = DataHandler.readFlugByUUID(flugUUID);
        if(flug == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(flug)
                .build();
    }
}
