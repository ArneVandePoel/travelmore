package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "betaling")
public class Betaling {

    //attributen
    @Id
    private int betalingID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "betalingMethodeID")
    private BetalingsMethoden betalingsMethode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boekingID")
    private Boeking boeking;

    //getters, setters
    public int getBetalingID() {
        return betalingID;
    }

    public void setBetalingID(int betalingID) {
        this.betalingID = betalingID;
    }

    public BetalingsMethoden getBetalingsMethode() {
        return betalingsMethode;
    }

    public void setBetalingsMethode(BetalingsMethoden betalingsMethode) {
        this.betalingsMethode = betalingsMethode;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }
}
