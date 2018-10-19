package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name="boeking")
public class Boeking {

    @Id
    private int boekingID;
    @Column(name = "isBetaald")
    private boolean isBetaald;
    @Column(name = "bedrag")
    private double bedrag;
    @ManyToOne
    private Gebruiker gebruiker;
    @OneToOne(mappedBy="boeking")
    private Betaling betaling;
    @ManyToOne
    private Reis reis;

    public int getBoekingID() {
        return boekingID;
    }

    public void setBoekingID(int boekingID) {
        this.boekingID = boekingID;
    }

    public boolean isBetaald() {
        return isBetaald;
    }

    public void setBetaald(boolean betaald) {
        isBetaald = betaald;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Betaling getBetaling() {
        return betaling;
    }

    public void setBetaling(Betaling betaling) {
        this.betaling = betaling;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }
}
