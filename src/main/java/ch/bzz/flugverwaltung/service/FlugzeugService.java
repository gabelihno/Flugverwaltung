package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Flugzeug;
import ch.bzz.flugverwaltung.model.Passagier;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

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

    /**
     * insert a new passenger
     * @param marke the first name
     * @param modell the birthday
     * @param baujahr the phonenumber
     * @return Response
     */
    @PUT
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertFlugzeug(
            @FormParam("marke") String marke,
            @FormParam("modell") String modell,
            @FormParam("baujahr") Integer baujahr
    ){
        Flugzeug flugzeug = new Flugzeug();
        flugzeug.setFlugzeugUUID(UUID.randomUUID().toString());
        flugzeug.setModell(modell);
        flugzeug.setMarke(marke);
        flugzeug.setBaujahr(baujahr);

        DataHandler.insertFlugzeug(flugzeug);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a passenger
     * @param flugzeugUUID the key
     * @param marke the name
     * @param modell the first name
     * @param baujahr the birthday
     * @return Response
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @FormParam("flugzeugUUID") String flugzeugUUID,
            @FormParam("marke") String marke,
            @FormParam("modell") String modell,
            @FormParam("baujahr") Integer baujahr
    ){
        int httpStatus = 200;
        Flugzeug flugzeug = DataHandler.readFlugzeugByUUID(flugzeugUUID);
        if(flugzeug != null) {
            flugzeug.setMarke(marke);
            flugzeug.setModell(modell);
            flugzeug.setBaujahr(baujahr);

            DataHandler.updateFlugzeug();
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
     * @param flugzeugUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFlugzeug(
            @QueryParam("uuid") String flugzeugUUID
    ){
        int httpStatus = 200;
        if(!DataHandler.deleteFlugzeug(flugzeugUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
