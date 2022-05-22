package ch.bzz.flugverwaltung.model;

import java.util.List;

/**
 * Ein Flug, welches einen Flugzeug besitzt und Passagiere
 */

public class Flug {
    private String flugUUID;
    private List<Passagier> passagierListe;
    private Flugzeug flugzeug;
    private Flug flug;

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
    public Flugzeug getFlugzeug() {
        return flugzeug;
    }

    /**
     * sets flugUUID
     */
    public void setFlugzeug(Flugzeug flugzeug) {
        this.flugzeug = flugzeug;
    }

    /**
     * gets flug
     * @return value of the variable flug
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


