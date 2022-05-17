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

    /**
     * bekommt flugzeugUUID
     * @return wert der Variable flugzeugUUID
     */
    public String getFlugzeugUUID() {
        return flugzeugUUID;
    }

    /**
     * setzt flugzeugUUID
     */
    public void setFlugzeugUUID(String flugzeugUUID) {
        this.flugzeugUUID = flugzeugUUID;
    }

    /**
     * bekommt marke
     * @return wert der Variable marke
     */
    public String getMarke() {
        return marke;
    }

    /**
     * setzt marke
     */
    public void setMarke(String marke) {
        this.marke = marke;
    }

    /**
     * bekommt modell
     * @return wert der Variable modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * setzt modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * bekommt baujahr
     * @return wert der Variable baujahr
     */
    public Integer getBaujahr() {
        return baujahr;
    }

    /**
     * setzt baujahr
     */
    public void setBaujahr(Integer baujahr) {
        this.baujahr = baujahr;
    }
}
