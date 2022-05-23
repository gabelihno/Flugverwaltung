package ch.bzz.flugverwaltung.model;

import ch.bzz.flugverwaltung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Flug, welches einen Flugzeug besitzt und Passagiere
 */
public class Flug {
    private String flugUUID;
    @JsonIgnore
    private List<Passagier> passagierListe;
    @JsonIgnore
    private Flugzeug flugzeugUUID;

    @JsonProperty("passagierListe")
    public void setPassagierListeByUUID(List<String> passagierListeUUIDS) {
        setPassagierListe(new ArrayList<>());
        for (String s : passagierListeUUIDS) {
            this.passagierListe.add(DataHandler.getInstance().readPassagierByUUID(s));
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
    public List<Passagier> getPassagierListe() {
        return passagierListe;
    }

    /**
     * sets passagierListe
     */
    public void setPassagierListe(List<Passagier> passagierListe) {
        this.passagierListe = passagierListe;
    }

    /**
     * gets flugUUID
     * @return value of the variable flugUUID
     */
    public Flugzeug getFlugzeugUUID() {
        return flugzeugUUID;
    }

    /**
     * sets flugUUID
     */
    public void setFlugzeugUUID(Flugzeug flugzeugUUID) {
        this.flugzeugUUID = flugzeugUUID;
    }

}


