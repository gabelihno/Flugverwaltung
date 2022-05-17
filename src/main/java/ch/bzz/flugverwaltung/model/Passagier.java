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

    public String getPassagierUUID() {
        return passagierUUID;
    }

    public void setPassagierUUID(String passagierUUID) {
        this.passagierUUID = passagierUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getHandynummer() {
        return handynummer;
    }

    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    public Flug getFlug() {
        return flug;
    }

    public void setFlug(Flug flug) {
        this.flug = flug;
    }
}
