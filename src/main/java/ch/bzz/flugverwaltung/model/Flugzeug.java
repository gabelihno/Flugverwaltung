package ch.bzz.flugverwaltung.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * model class flugzeug
 */
public class Flugzeug {
    private String planeUUID;
    private String airline;
    private String model;
    private Integer constructionYear;

    /**
     * gets planeUUID
     * @return value of the varible planeUUID
     */
    public String getplaneUUID() {
        return planeUUID;
    }

    /**
     * sets planeUUID
     */
    public void setplaneUUID(String planeUUID) {
        this.planeUUID = planeUUID;
    }

    /**
     * gets airline
     * @return value of the varible airline
     */
    public String getairline() {
        return airline;
    }

    /**
     * sets airline
     */
    public void setairline(String airline) {
        this.airline = airline;
    }

    /**
     * gets model
     * @return value of the varible model
     */
    public String getmodel() {
        return model;
    }

    /**
     * sets model
     */
    public void setmodel(String model) {
        this.model = model;
    }

    /**
     * gets constructionYear
     * @return value of the varible constructionYear
     */
    public Integer getconstructionYear() {
        return constructionYear;
    }

    /**
     * sets constructionYear
     */
    public void setconstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }
}
