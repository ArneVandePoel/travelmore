package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gebruikerstype")
public class GebruikersType {

    //attributen
    @Id
    private int gebruikersTypeID;
    @Column(name = "type")
    private String type;

    //getters, setters
    public int getGebruikersTypeID() {
        return gebruikersTypeID;
    }

    public void setGebruikersTypeID(int gebruikersTypeID) {
        this.gebruikersTypeID = gebruikersTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
