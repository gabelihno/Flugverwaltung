package ch.bzz.flugverwaltung.data;

import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Flugzeug;
import ch.bzz.flugverwaltung.model.Passagier;
import ch.bzz.flugverwaltung.service.Config;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads data from the json files
 */

public final class DataHandler {
    private static DataHandler instance = null;
    private static List<Passagier> passagierList;
    private static List<Flug> flugList;
    private static List<Flugzeug> flugzeugList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }


    /**
     * reads all passengers
     * @return list of passengers
     */
    public static List<Passagier> readAllPassengers() {
        return getPassagierList();
    }

    /**
     * reads a Passenger by its uuid
     * @param PassagierUUID
     * @return the Passagier (null=not found)
     */

    public static Passagier readPassagierByUUID(String PassagierUUID) {
        Passagier passagier = null;
        for (Passagier entry : getPassagierList()) {
            if (entry.getPassagierUUID().equals(PassagierUUID)) {
                passagier = entry;
            }
        }
        return passagier;
    }

    /**
     * reads all flugzeugs
     * @return list of flugzeugs
     */
    public static List<Flugzeug> readAllFlugzeugs() {
        return getFlugzeugList();
    }

    /**
     * reads a Passenger by its uuid
     * @param flugzeugUUID
     * @return the Flugzeug (null=not found)
     */
    public static Flugzeug readFlugzeugByUUID(String flugzeugUUID) {
        Flugzeug flugzeug = null;
        for (Flugzeug entry : getFlugzeugList()) {
            if (entry.getFlugzeugUUID().equals(flugzeugUUID)) {
                flugzeug = entry;
            }
        }
        return flugzeug;
    }


    /**
     * reads all Publishers
     * @return list of publishers
     */
    public static List<Flug> readAllFlugs() { return getFlugList(); }

    /**
     * reads a Flug by its uuid
     * @param flugUUID
     * @return the Flug (null=not found)
     */
    public static Flug readFlugByUUID(String flugUUID) {
        Flug flug = null;
        for (Flug entry : getFlugList()) {
            if (entry.getFlugUUID().equals(flugUUID)) {
                flug = entry;
            }
        }
        return flug;
    }

    /**
     * reads the passengers from the JSON-file
     */
    private static void readPassagierJSON() {
        try {
            String path = Config.getProperty("passagierJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Passagier[] passagiers = objectMapper.readValue(jsonData, Passagier[].class);
            for (Passagier passagier : passagiers) {
                getPassagierList().add(passagier);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the flyies from the JSON-file
     */
    private static void readFlugJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("flugJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Flug[] flugs = objectMapper.readValue(jsonData, Flug[].class);
            for (Flug flug : flugs) {
                getFlugList().add(flug);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the flugzeugs from the JSON-file
     */
    private static void readFlugzeugJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("flugzeugJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Flugzeug[] flugzeugs = objectMapper.readValue(jsonData, Flugzeug[].class);
            for (Flugzeug flugzeug : flugzeugs) {
                getFlugzeugList().add(flugzeug);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * gets passagierList
     *
     * @return value of passagierList
     */
    private static List<Passagier> getPassagierList() {
        if (passagierList == null) {
            setPassagierList(new ArrayList<>());
            readPassagierJSON();
        }
        return passagierList;
    }

    /**
     * sets passagierList
     *
     * @param passagierList the value to set
     */
    private static void setPassagierList(List<Passagier> passagierList) {
        DataHandler.passagierList = passagierList;
    }

    /**
     * gets flugList
     *
     * @return value of flugList
     */
    private static List<Flug> getFlugList() {
        if (flugList == null) {
            setFlugList(new ArrayList<>());
            readFlugJSON();
        }
        return flugList;
    }

    /**
     * sets flugList
     *
     * @param flugList the value to set
     */
    private static void setFlugList(List<Flug> flugList) {
        DataHandler.flugList = flugList;
    }

    /**
     * gets flugzeugList
     *
     * @return value of flugzeugList
     */
    private static List<Flugzeug> getFlugzeugList() {
        if (flugzeugList == null) {
            setFlugzeugList(new ArrayList<>());
            readFlugzeugJSON();
        }
        return flugzeugList;
    }

    /**
     * sets flugzeugList
     *
     * @param flugzeugList the value to set
     */
    private static void setFlugzeugList(List<Flugzeug> flugzeugList) {
        DataHandler.flugzeugList = flugzeugList;
    }

}
