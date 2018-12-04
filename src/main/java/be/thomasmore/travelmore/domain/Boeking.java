package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name="boeking")
@NamedQueries(
        {
                @NamedQuery(
                        name = Boeking.FIND_BOEKINGEN_GEBRUIKER,
                        query = "SELECT b FROM Boeking b WHERE (b.gebruiker) = :gebruiker ORDER BY b.isBetaald"
                ),
                @NamedQuery(
                        name = Boeking.FIND_ALL,
                        query = "SELECT b FROM Boeking b"
                )
        }
)
public class Boeking {
    public static final String FIND_BOEKINGEN_GEBRUIKER = "Boeking.findBoekingenGebruiker";
    public static final String FIND_ALL = "Boeking.findAll";

    @Id
    private int boekingID;
    @Column(name = "isBetaald")
    private boolean isBetaald;
    @Column(name = "bedrag")
    private double bedrag;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gebruikerID")
    private Gebruiker gebruiker;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "betalingsMethodeID")
    private BetalingsMethoden betalingsMethode;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reisID")
    private Reis reis;

    public int getBoekingID() {
        return boekingID;
    }

    public void setBoekingID(int boekingID) {
        this.boekingID = boekingID;
    }

    public boolean getIsBetaald() {
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

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public BetalingsMethoden getBetalingsMethode() {
        return betalingsMethode;
    }

    public void setBetalingsMethode(BetalingsMethoden betalingsMethode) {
        this.betalingsMethode = betalingsMethode;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }
}
