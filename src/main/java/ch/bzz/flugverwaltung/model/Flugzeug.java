package ch.bzz.flugverwaltung.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

/**
 * model class flugzeug
 */
public class Flugzeug {

    @FormParam("flugzeugUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String flugzeugUUID;

    @FormParam("marke")
    @NotEmpty
    @Size(min=5, max=40)
    private String marke;

    @FormParam("modell")
    @NotEmpty
    @Size(min=5, max=40)
    private String modell;

    @FormParam("baujahr")
    @NotNull
    @Min(1800)
    @Max(2022)
    private Integer baujahr;

    /**
     * gets flugzeugUUID
     * @return value of the variable flugzeugUUID
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
