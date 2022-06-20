package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Passagier;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

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
     * @param passagierUUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPassenger(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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

    /**
     * insert a new passenger
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @Valid @BeanParam Passagier passagier
            ){
        passagier.setPassagierUUID(UUID.randomUUID().toString());

        DataHandler.insertPassagier(passagier);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a passenger
     * @param passagierUUID the key
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @Valid @BeanParam Passagier passagier,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("passagierUUID") String passagierUUID
    ){
        int httpStatus = 200;
        Passagier oldPassagier = DataHandler.readPassagierByUUID(passagierUUID);
        if(oldPassagier != null) {
            oldPassagier.setName(passagier.getName());
            oldPassagier.setVorname(passagier.getVorname());
            oldPassagier.setGeburtsdatum(passagier.getGeburtsdatum());
            oldPassagier.setHandynummer(passagier.getHandynummer());

            DataHandler.updatePassagier();
        }
        else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a passenger by UUID
     * @param passagierUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePassenger(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String passagierUUID
    ){
        int httpStatus = 200;
        if(!DataHandler.deletePassagier(passagierUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
