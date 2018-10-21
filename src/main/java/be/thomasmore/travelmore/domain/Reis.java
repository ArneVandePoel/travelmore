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
    @Column(name = "tijdstipVertrekHeen")
    private Date tijdstipVertrekHeen;
    @Column(name = "tijdstipAankomstHeen")
    private Date tijdstipAankomstHeen;
    @Column(name = "tijdstipVertrekTerug")
    private Date tijdstipVertrekTerug;
    @Column(name = "tijdstipAankomstTerug")
    private Date tijdstipAankomstTerug;
    @Column(name = "reisLeiderNaam")
    private String reisLeiderNaam;
    @Column(name = "chauffeurNaam")
    private String chauffeurNaam;
    @Column(name = "titel")
    private String titel;
    @Column(name = "beschrijving")
    private String beschrijving;

    @ManyToOne
    private Locatie vertrekLocatie;
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

    public Date getTijdstipVertrekHeen() {
        return tijdstipVertrekHeen;
    }

    public void setTijdstipVertrekHeen(Date tijdstipVertrekHeen) {
        this.tijdstipVertrekHeen = tijdstipVertrekHeen;
    }

    public Date getTijdstipAankomstHeen() {
        return tijdstipAankomstHeen;
    }

    public void setTijdstipAankomstHeen(Date tijdstipAankomstHeen) {
        this.tijdstipAankomstHeen = tijdstipAankomstHeen;
    }

    public Date getTijdstipVertrekTerug() {
        return tijdstipVertrekTerug;
    }

    public void setTijdstipVertrekTerug(Date tijdstipVertrekTerug) {
        this.tijdstipVertrekTerug = tijdstipVertrekTerug;
    }

    public Date getTijdstipAankomstTerug() {
        return tijdstipAankomstTerug;
    }

    public void setTijdstipAankomstTerug(Date tijdstipAankomstTerug) {
        this.tijdstipAankomstTerug = tijdstipAankomstTerug;
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

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
