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
            @QueryParam("uuid") String planeUUID
    ){
        int httpStatus = 200;
        Flugzeug flugzeug = DataHandler.readFlugzeugByUUID(planeUUID);
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
     * @param airline the first name
     * @param model the birthday
     * @param constructionYear the phonenumber
     * @return Response
     */
    @PUT
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertFlugzeug(
            @FormParam("airline") String airline,
            @FormParam("model") String model,
            @FormParam("constructionYear") Integer constructionYear
    ){
        Flugzeug flugzeug = new Flugzeug();
        flugzeug.setplaneUUID(UUID.randomUUID().toString());
        flugzeug.setmodel(model);
        flugzeug.setairline(airline);
        flugzeug.setconstructionYear(constructionYear);

        DataHandler.insertFlugzeug(flugzeug);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a passenger
     * @param planeUUID the key
     * @param airline the name
     * @param model the first name
     * @param constructionYear the birthday
     * @return Response
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @FormParam("planeUUID") String planeUUID,
            @FormParam("airline") String airline,
            @FormParam("model") String model,
            @FormParam("constructionYear") Integer constructionYear
    ){
        int httpStatus = 200;
        Flugzeug flugzeug = DataHandler.readFlugzeugByUUID(planeUUID);
        if(flugzeug != null) {
            flugzeug.setairline(airline);
            flugzeug.setmodel(model);
            flugzeug.setconstructionYear(constructionYear);

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
     * @param planeUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFlugzeug(
            @QueryParam("uuid") String planeUUID
    ){
        int httpStatus = 200;
        if(!DataHandler.deleteFlugzeug(planeUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
