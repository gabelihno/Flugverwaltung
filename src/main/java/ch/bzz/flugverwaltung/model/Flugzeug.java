package ch.bzz.flugverwaltung.model;

/**
 * Flugzeug, welches zu einem Flug gehört.
 */

public class Flugzeug {
    private String flugzeugUUID;
    private String marke;
    private String modell;
    private Integer baujahr;

    public Flugzeug(String flugzeugUUID, String marke, String modell, Integer baujahr) {
        this.flugzeugUUID = flugzeugUUID;
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
    }

    public String getFlugzeugUUID() {
        return flugzeugUUID;
    }

    public void setFlugzeugUUID(String flugzeugUUID) {
        this.flugzeugUUID = flugzeugUUID;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(Integer baujahr) {
        this.baujahr = baujahr;
    }
}
