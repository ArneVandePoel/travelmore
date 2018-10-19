package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reis")
public class Reis {

    //attributen
    @Id
    private int reisID;
    @Column(name = "prijs")
    private double prijs;
    @Column(name = "tijdstipVertrek")
    private Date tijdstipVertrek;
    @Column(name = "tijdstipAankomst")
    private Date tijdstipAankomst;
    @Column(name = "reisLeiderNaam")
    private String reisLeiderNaam;
    @Column(name = "chauffeurNaam")
    private String chauffeurNaam;

    @ManyToOne
    private Locatie vertrekLocatie;
    @ManyToOne
    private Locatie aankomstLocatie;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Bus bus;

    //getters, setters
    public int getReisID() {
        return reisID;
    }

    public void setReisID(int reisID) {
        this.reisID = reisID;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Date getTijdstipVertrek() {
        return tijdstipVertrek;
    }

    public void setTijdstipVertrek(Date tijdstipVertrek) {
        this.tijdstipVertrek = tijdstipVertrek;
    }

    public Date getTijdstipAankomst() {
        return tijdstipAankomst;
    }

    public void setTijdstipAankomst(Date tijdstipAankomst) {
        this.tijdstipAankomst = tijdstipAankomst;
    }

    public String getReisLeiderNaam() {
        return reisLeiderNaam;
    }

    public void setReisLeiderNaam(String reisLeiderNaam) {
        this.reisLeiderNaam = reisLeiderNaam;
    }

    public String getChauffeurNaam() {
        return chauffeurNaam;
    }

    public void setChauffeurNaam(String chauffeurNaam) {
        this.chauffeurNaam = chauffeurNaam;
    }

    public Locatie getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(Locatie vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public Locatie getAankomstLocatie() {
        return aankomstLocatie;
    }

    public void setAankomstLocatie(Locatie aankomstLocatie) {
        this.aankomstLocatie = aankomstLocatie;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
