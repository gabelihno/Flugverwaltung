package ch.bzz.flugverwaltung.data;

import ch.bzz.flugverwaltung.model.Flug;
import ch.bzz.flugverwaltung.model.Flugzeug;
import ch.bzz.flugverwaltung.model.Passagier;
import ch.bzz.flugverwaltung.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static DataHandler instance = null;
    private List<Passagier> passagierList;
    private List<Flug> flugList;
    private List<Flugzeug> flugzeugList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setFlugList(new ArrayList<>());
        readFlugJSON();
        setPassagierList(new ArrayList<>());
        readPassagierJSON();
        setFlugzeugList(new ArrayList<>());
        readFlugzeugJSON();
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all passengers
     * @return list of passengers
     */
    public List<Passagier> readAllPassengers() {
        return getPassagierList();
    }

    /**
     * reads a Passenger by its uuid
     * @param PassagierUUID
     * @return the Passagier (null=not found)
     */
    public Passagier readPassagierByUUID(String PassagierUUID) {
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
    public List<Flugzeug> readAllFlugzeugs() {
        return getFlugzeugList();
    }

    /**
     * reads a Passenger by its uuid
     * @param flugzeugUUID
     * @return the Flugzeug (null=not found)
     */
    public Flugzeug readFlugzeugByUUID(String flugzeugUUID) {
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
    public List<Flug> readAllFlugs() {

        return getFlugList();
    }

    /**
     * reads a Flug by its uuid
     * @param flugUUID
     * @return the Flug (null=not found)
     */
    public Flug readFlugByUUID(String flugUUID) {
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
    private void readPassagierJSON() {
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
    private void readFlugJSON() {
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
    private void readFlugzeugJSON() {
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
    private List<Passagier> getPassagierList() {
        return passagierList;
    }

    /**
     * sets passagierList
     *
     * @param passagierList the value to set
     */
    private void setPassagierList(List<Passagier> passagierList) {
        this.passagierList = passagierList;
    }

    /**
     * gets flugList
     *
     * @return value of flugList
     */
    private List<Flug> getFlugList() {
        return flugList;
    }

    /**
     * sets flugList
     *
     * @param flugList the value to set
     */
    private void setFlugList(List<Flug> flugList) {
        this.flugList = flugList;
    }

    /**
     * gets flugzeugList
     *
     * @return value of flugzeugList
     */
    private List<Flugzeug> getFlugzeugList() {
        return flugzeugList;
    }

    /**
     * sets flugzeugList
     *
     * @param flugzeugList the value to set
     */
    private void setFlugzeugList(List<Flugzeug> flugzeugList) {
        this.flugzeugList = flugzeugList;
    }



}
