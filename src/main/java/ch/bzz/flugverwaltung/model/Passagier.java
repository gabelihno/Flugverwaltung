package ch.bzz.flugverwaltung.model;

import ch.bzz.flugverwaltung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

/**
 * model class passagier
 */
public class Passagier {

    private String passagierUUID;
    private String name;
    private String vorname;
    private String geburtsdatum;
    private String handynummer;
    @JsonIgnore
    private Flug flug;

    /**
     * gets the FlugUUID from the Flug-object
     * @return
     */
    @JsonProperty("flug")
    public String getFlugUUID() {
        if(flug != null){
            return getFlug().getFlugUUID();
        }
        else {
            return null;
        }
    }

    /**
     * creates a Flug-object without the passengerlist
     * @param flugUUID
     */
    public void setFlugUUID(String flugUUID) {
        setFlug( new Flug());
        Flug flug = DataHandler.getInstance().readFlugByUUID(flugUUID);
        getFlug().setFlugUUID(flugUUID);
        getFlug().setFlugzeugUUID(flug.getFlugzeugUUID());
    }

    /**
     * gets passagierUUID
     * @return value of the varible passagierUUID
     */
    public String getPassagierUUID() {
        return passagierUUID;
    }

    /**
     * sets passagierUUID
     */
    public void setPassagierUUID(String passagierUUID) {
        this.passagierUUID = passagierUUID;
    }

    /**
     * gets name
     * @return value of the varible name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets vorname
     * @return value of the varible vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * sets vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * gets geburtsdatum
     * @return value of the varible geburtsdatum
     */
    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * sets geburtsdatum
     */
    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    /**
     * gets handynummer
     * @return value of the varible handynummer
     */
    public String getHandynummer() {
        return handynummer;
    }

    /**
     * sets handynummer
     */
    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    /**
     * gets flug
     * @return value of the varible flug
     */
    public Flug getFlug() {
        return flug;
    }

    /**
     * sets flug
     */
    public void setFlug(Flug flug) {
        this.flug = flug;
    }
}
