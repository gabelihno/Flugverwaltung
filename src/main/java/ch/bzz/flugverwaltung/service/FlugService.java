package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.data.DataHandler;
import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Flugzeug;
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
 * services for reading, adding, changing and deleting flights
 */
@Path("flug")
public class FlugService {
    /**
     * reads a list of all flights
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugs(
            @CookieParam("userRole") String userRole
    ){
        List<Flug> flugList = null;
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flugList = DataHandler.readAllFlugs();
        }

        return Response
                .status(httpStatus)
                .entity(flugList)
                .build();
    }

    /**
     * reads a flight by UUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlug(
            @CookieParam("userRole") String userRole,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String flugUUID
    ){
        Flug flug = null;
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flug = DataHandler.readFlugByUUID(flugUUID);
            if(flug == null) {
                httpStatus = 410;
            }
        }

        return Response
                .status(httpStatus)
                .entity(flug)
                .build();
    }
    /**
     * insert a new flight
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertFlug(
            @CookieParam("userRole") String userRole,
            @Valid @BeanParam Flug flug
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flug.setFlugUUID(UUID.randomUUID().toString());
            DataHandler.insertFlug(flug);
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * updates a flight
     * @param flugUUID the key
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @CookieParam("userRole") String userRole,
            @Valid @BeanParam Flug flug,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("flugUUID") String flugUUID
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            Flug oldFlug = DataHandler.readFlugByUUID(flugUUID);
            if(oldFlug != null) {
                oldFlug.setStrecke(flug.getStrecke());

                DataHandler.updateFlug();
            }
            else {
                httpStatus = 410;
            }
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a flight by UUID
     * @param flugUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFlug(
            @CookieParam("userRole") String userRole,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String flugUUID
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            if(!DataHandler.deleteFlug(flugUUID)){
                httpStatus = 410;
            }
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

}
