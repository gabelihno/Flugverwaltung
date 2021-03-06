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
 * services for reading, adding, changing and deleting flugzeugs
 */
@Path("flugzeug")
public class FlugzeugService {
    /**
     * reads a list of all planes
     *
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFlugzeugs(
            @CookieParam("userRole") String userRole
    ) {
        List<Flugzeug> flugzeugList = null;
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flugzeugList = DataHandler.readAllFlugzeugs();
        }

        return Response
                .status(httpStatus)
                .entity(flugzeugList)
                .build();
    }

    /**
     * reads a plane by UUID
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFlugzeug(
            @CookieParam("userRole") String userRole,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String flugzeugUUID
    ){
        Flugzeug flugzeug = null;
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flugzeug = DataHandler.readFlugzeugByUUID(flugzeugUUID);
            if (flugzeug == null){
                httpStatus = 410;
            }
        }

        return Response
                .status(httpStatus)
                .entity(flugzeug)
                .build();
    }

    /**
     * insert a new plane
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertFlugzeug(
            @CookieParam("userRole") String userRole,
            @Valid @BeanParam Flugzeug flugzeug
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            flugzeug.setFlugzeugUUID(UUID.randomUUID().toString());
            DataHandler.insertFlugzeug(flugzeug);
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * updates a plane
     * @param flugzeugUUID the key
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPassenger(
            @CookieParam("userRole") String userRole,
            @Valid @BeanParam Flugzeug flugzeug,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("flugzeugUUID") String flugzeugUUID
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else{
            httpStatus = 200;
            Flugzeug oldFlugzeug = DataHandler.readFlugzeugByUUID(flugzeugUUID);
            if(oldFlugzeug != null) {
                oldFlugzeug.setMarke(flugzeug.getMarke());
                oldFlugzeug.setModell(flugzeug.getModell());
                oldFlugzeug.setBaujahr(flugzeug.getBaujahr());

                DataHandler.updateFlugzeug();
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
     * deletes a plane by UUID
     * @param flugzeugUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFlugzeug(
            @CookieParam("userRole") String userRole,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String flugzeugUUID
    ){
        int httpStatus;
        if(userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        }
        else {
            httpStatus = 200;
            if(!DataHandler.deleteFlugzeug(flugzeugUUID)){
                httpStatus = 410;
            }
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
