package ch.bzz.flugverwaltung.model;

import ch.bzz.flugverwaltung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 * model class flug
 */
public class Flug {
    private String flugUUID;
    private Integer strecke;



    @JsonIgnore
    private List<Passagier> passagierListe;
    @JsonIgnore
    private Flugzeug flugzeugUUID;

    @JsonProperty("passagierListe")
    public void setPassagierListeByUUID(List<String> passagierListeUUIDS) {
        setPassagierListe(new ArrayList<>());
        for (String s : passagierListeUUIDS) {
            this.passagierListe.add(DataHandler.readPassagierByUUID(s));
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
     * gets strecke
     *
     * @return wert der Variable strecke
     */
    public Integer getStrecke() {
        return strecke;
    }

    /**
     * sets strecke
     */
    public void setStrecke(Integer strecke) {
        this.strecke = strecke;
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


