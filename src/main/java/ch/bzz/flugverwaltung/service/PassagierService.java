package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Passagier;

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
     * @param name the name
     * @param vorname the first name
     * @param geburtsdatum the birthday
     * @param handynummer the phonenumber
     * @return Response
     */
    @PUT
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @FormParam("name") String name,
            @FormParam("vorname") String vorname,
            @FormParam("geburtsdatum") String geburtsdatum,
            @FormParam("handynummer") String handynummer
            ){
        Passagier passagier = new Passagier();
        passagier.setPassagierUUID(UUID.randomUUID().toString());
        passagier.setName(name);
        passagier.setVorname(vorname);
        passagier.setGeburtsdatum(geburtsdatum);
        passagier.setHandynummer(handynummer);

        DataHandler.insertPassagier(passagier);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a passenger
     * @param passagierUUID the key
     * @param name the name
     * @param vorname the first name
     * @param geburtsdatum the birthday
     * @param handynummer the phonenumber
     * @return Response
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @FormParam("passagierUUID") String passagierUUID,
            @FormParam("name") String name,
            @FormParam("vorname") String vorname,
            @FormParam("geburtsdatum") String geburtsdatum,
            @FormParam("handynummer") String handynummer
    ){
        int httpStatus = 200;
        Passagier passagier = DataHandler.readPassagierByUUID(passagierUUID);
        if(passagier != null) {
            passagier.setName(name);
            passagier.setVorname(vorname);
            passagier.setGeburtsdatum(geburtsdatum);
            passagier.setHandynummer(handynummer);

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
