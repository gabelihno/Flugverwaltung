package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Passagier;

import javax.ws.rs.*;
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
        List<Passagier> passagierList = DataHandler.readAllPassengers();
        return Response
                .status(200)
                .entity(passagierList)
                .build();
    }


    /**
     * reads a passenger by UUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPassenger(
            @QueryParam("uuid") String passagierUUID
    ){
        int httpStatus = 200;
        Passagier passagier = DataHandler.readPassagierByUUID(passagierUUID);
        if(passagier == null) {
            httpStatus = 410;
        }
            return Response
                    .status(httpStatus)
                    .entity(passagier)
                    .build();
    }

//    @DELETE
//    @Path("delete")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response deletePassenger(
//
//    )
}
