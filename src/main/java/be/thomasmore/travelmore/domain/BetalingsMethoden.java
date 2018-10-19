package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "betalingsmethoden")
public class BetalingsMethoden {

    //attributen
    @Id
    private int betalingsMethodeID;
    @Column(name = "naam")
    private String naam;

    //getters, setters
    public int getBetalingsMethodeID() {
        return betalingsMethodeID;
    }

    public void setBetalingsMethodeID(int betalingsMethodeID) {
        this.betalingsMethodeID = betalingsMethodeID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
