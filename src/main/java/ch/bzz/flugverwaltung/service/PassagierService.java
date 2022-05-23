package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Passagier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * services for reading, adding, changing and deleting passengers
 */
@Path("passagier")
public class PassagierService {
    /**
     * reads a list of all Passengers
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPassagiers(){
        List<Passagier> passagierList = DataHandler.getInstance().readAllPassengers();
        return Response
                .status(200)
                .entity(passagierList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPassenger(
            @QueryParam("uuid") String passagierUUID
    ){
        Passagier passagier = DataHandler.getInstance().readPassagierByUUID(passagierUUID);
        if(passagier != null){
            return Response
                    .status(200)
                    .entity(passagier)
                    .build();
        }
        else {
            return Response
                    .status(404)
                    .build();
        }
    }
}
