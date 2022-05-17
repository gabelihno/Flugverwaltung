package ch.bzz.flugverwaltung.model;

import java.util.List;

/**
 * Ein Flug, welches einen Flugzeug besitzt und Passagiere
 */

public class Flug {
    private String flugUUID;
    private List<Passagier> passagierListe;
    private Flugzeug flugzeug;

/**
 * Konstruktor für alle Attribute
 */
    public Flug(String flugUUID, List<Passagier> passagierListe, Flugzeug flugzeug) {
        this.flugUUID = flugUUID;
        this.passagierListe = passagierListe;
        this.flugzeug = flugzeug;
    }

/**
 * bekommt flugUUID
 * @return wert der Variable flugUUID
 */
    public String getFlugUUID() {
        return flugUUID;
    }

/**
 * setzt flugUUID
 */
    public void setFlugUUID(String flugUUID) {
        this.flugUUID = flugUUID;
    }

/**
 * bekommt passagierListe
 * @return wert der Liste passagierListe
 */
    public List<Passagier> getPassagierListe() {
        return passagierListe;
    }

    public void setPassagierListe(List<Passagier> passagierListe) {
        this.passagierListe = passagierListe;
    }

    public Flugzeug getFlugzeug() {
        return flugzeug;
    }

    public void setFlugzeug(Flugzeug flugzeug) {
        this.flugzeug = flugzeug;
    }
}
