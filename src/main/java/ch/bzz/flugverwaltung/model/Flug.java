package ch.bzz.flugverwaltung.model;

import ch.bzz.flugverwaltung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

/**
 * Ein Flug, welches einen Flugzeug besitzt und Passagiere
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class,property = "flugUUID")
public class Flug {
    private String flugUUID;
    private List<String> passagierListe;
    private Flugzeug flugzeug;

    @JsonProperty("flugzeug")
    public String getFlugzeugUUID() {
        if (flugzeug != null){
            return getFlugzeug().getFlugzeugUUID();
        }
        else {
            return null;
        }
    }

/**
 * gets flugUUID
 * @return value of the variable flugUUID
 */
    public String getFlugUUID() {
        return flugUUID;
    }

/**
 * sets flugUUID
 */
    public void setFlugUUID(String flugUUID) {
        this.flugUUID = flugUUID;
    }

/**
 * gets passagierListe
 * @return value of the variable passagierListe
 */
    public List<String> getPassagierListe() {
        return passagierListe;
    }

    /**
     * sets passagierListe
     */
    public void setPassagierListe(List<String> passagierListe) {
        this.passagierListe = passagierListe;
    }

    /**
     * gets flugUUID
     * @return value of the variable flugUUID
     */
    public Flugzeug getFlugzeug() {
        return flugzeug;
    }

    /**
     * sets flugUUID
     */
    public void setFlugzeug(Flugzeug flugzeug) {
        this.flugzeug = flugzeug;
    }

}


