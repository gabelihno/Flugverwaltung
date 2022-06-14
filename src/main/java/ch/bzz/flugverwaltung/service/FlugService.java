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
//    /**
//     * insert a new passenger
//     * @param passagierListe the name
//     * @param flugzeugUUID the first name
//     * @return Response
//     */
//    @PUT
//    @Path("create")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response insertFlug(
//            @FormParam("passagierListe") List<Passagier> passagierListe,
//            @FormParam("flugzeugUUID") Flugzeug flugzeugUUID
//    ){
//        Flug flug = new Flug();
//        flug.setFlugUUID(UUID.randomUUID().toString());
//        flug.setPassagierListe(passagierListe);
//        flug.setFlugzeugUUID(flugzeugUUID);
//
//        DataHandler.insertFlug(flug);
//        return Response
//                .status(200)
//                .entity("")
//                .build();
//    }

//    /**
//     * updates a passenger
//     * @param passagierUUID the key
//     * @param name the name
//     * @param vorname the first name
//     * @param geburtsdatum the birthday
//     * @param handynummer the phonenumber
//     * @return Response
//     */
//    @POST
//    @Path("update")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response insertPassenger(
//            @FormParam("passagierUUID") String passagierUUID,
//            @FormParam("name") String name,
//            @FormParam("vorname") String vorname,
//            @FormParam("geburtsdatum") String geburtsdatum,
//            @FormParam("handynummer") String handynummer
//    ){
//        int httpStatus = 200;
//        Passagier passagier = DataHandler.readPassagierByUUID(passagierUUID);
//        if(passagier != null) {
//            passagier.setName(name);
//            passagier.setVorname(vorname);
//            passagier.setGeburtsdatum(geburtsdatum);
//            passagier.setHandynummer(handynummer);
//
//            DataHandler.updatePassagier();
//        }
//        else {
//            httpStatus = 410;
//        }
//        return Response
//                .status(httpStatus)
//                .entity("")
//                .build();
//    }

    /**
     * deletes a Flug by UUID
     * @param flugUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePassenger(
            @QueryParam("uuid") String flugUUID
    ){
        int httpStatus = 200;
        if(!DataHandler.deleteFlug(flugUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

}
