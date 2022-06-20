package ch.bzz.flugverwaltung.model;

import ch.bzz.flugverwaltung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.time.LocalDate;

/**
 * model class passagier
 */
public class Passagier {

    @FormParam("passagierUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String passagierUUID;

    @FormParam("name")
    @NotEmpty
    @Size(min=5, max=40)
    private String name;

    @FormParam("vorname")
    @NotEmpty
    @Size(min=5, max=40)
    private String vorname;

    @FormParam("geburtsdatum")
    @NotEmpty
    @Size(min=10, max=10)
    private String geburtsdatum;

    @FormParam("handynummer")
    @NotEmpty
    @Pattern(regexp = "0(2[1-246-7]|3[1-4]|4[13-4]|5[25-6]|6[1-2]|7[15-68-9]|8[17]|91)[0-9]{7}")
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
        Flug flug = DataHandler.readFlugByUUID(flugUUID);
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
