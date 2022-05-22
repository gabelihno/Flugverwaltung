package ch.bzz.flugverwaltung.model;

/**
 * Flugzeug, welches zu einem Flug gehört.
 */

public class Flugzeug {
    private String flugzeugUUID;
    private String marke;
    private String modell;
    private Integer baujahr;

    /**
     * gets flugzeugUUID
     * @return value of the varible flugzeugUUID
     */
    public String getFlugzeugUUID() {
        return flugzeugUUID;
    }

    /**
     * sets flugzeugUUID
     */
    public void setFlugzeugUUID(String flugzeugUUID) {
        this.flugzeugUUID = flugzeugUUID;
    }

    /**
     * gets marke
     * @return value of the varible marke
     */
    public String getMarke() {
        return marke;
    }

    /**
     * sets marke
     */
    public void setMarke(String marke) {
        this.marke = marke;
    }

    /**
     * gets modell
     * @return value of the varible modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * sets modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * gets baujahr
     * @return value of the varible baujahr
     */
    public Integer getBaujahr() {
        return baujahr;
    }

    /**
     * sets baujahr
     */
    public void setBaujahr(Integer baujahr) {
        this.baujahr = baujahr;
    }
}
