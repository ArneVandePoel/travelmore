package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "betalingsmethoden")
@NamedQueries(
        {
                @NamedQuery(
                        name = BetalingsMethoden.FIND_ALL,
                        query = "SELECT b FROM BetalingsMethoden b"
                )
        }
)
public class BetalingsMethoden {
    public static final String FIND_ALL = "BetalingsMethoden.findAll";

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
