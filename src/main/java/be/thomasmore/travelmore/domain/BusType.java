package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="busType")
public class BusType {

    @Id
    private int busTypeID;
    @Column(name = "type")
    private String type;
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;

    public int getBusTypeID() {
        return busTypeID;
    }

    public void setBusTypeID(int busTypeID) {
        this.busTypeID = busTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }
}
