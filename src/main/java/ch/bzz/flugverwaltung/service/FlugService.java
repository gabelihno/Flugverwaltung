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

@Path("flug")
public class FlugService {
    /**
     * reads a list of all Passengers
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugs(){
        List<Flug> flugList = DataHandler.getInstance().readAllFlugs();
        return Response
                .status(200)
                .entity(flugList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlug(
            @QueryParam("uuid") String flugUUID
    ){
        Flug flug = DataHandler.getInstance().readFlugByUUID(flugUUID);
        if(flug != null){
            return Response
                    .status(200)
                    .entity(flug)
                    .build();
        }
        else {
            return Response
                    .status(404)
                    .build();
        }

    }
}
