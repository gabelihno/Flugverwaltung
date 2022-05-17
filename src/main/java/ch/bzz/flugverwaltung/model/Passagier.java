package ch.bzz.flugverwaltung.model;

import java.time.LocalDate;

/**
 * Passagier für den Flug
 */

public class Passagier {
    private String passagierUUID;
    private String name;
    private String vorname;
    private LocalDate geburtsdatum;
    private String handynummer;
    private Flug flug;

    public Passagier(String passagierUUID, String name, String vorname, LocalDate geburtsdatum, String handynummer, Flug flug) {
        this.passagierUUID = passagierUUID;
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.handynummer = handynummer;
        this.flug = flug;
    }

    /**
     * bekommt passagierUUID
     * @return wert der Variable passagierUUID
     */
    public String getPassagierUUID() {
        return passagierUUID;
    }

    /**
     * setzt passagierUUID
     */
    public void setPassagierUUID(String passagierUUID) {
        this.passagierUUID = passagierUUID;
    }

    /**
     * bekommt name
     * @return wert der Variable name
     */
    public String getName() {
        return name;
    }

    /**
     * setzt name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * bekommt vorname
     * @return wert der Variable vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * setzt vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * bekommt geburtsdatum
     * @return wert der Variable geburtsdatum
     */
    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * setzt geburtsdatum
     */
    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    /**
     * bekommt handynummer
     * @return wert der Variable handynummer
     */
    public String getHandynummer() {
        return handynummer;
    }

    /**
     * setzt handynummer
     */
    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    /**
     * bekommt flug
     * @return wert der Variable flug
     */
    public Flug getFlug() {
        return flug;
    }

    /**
     * setzt flug
     */
    public void setFlug(Flug flug) {
        this.flug = flug;
    }
}
