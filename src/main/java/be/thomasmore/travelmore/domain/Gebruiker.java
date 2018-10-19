package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "gebruiker")
public class Gebruiker {

    //attributen
    @Id
    private int gebruikerID;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wacthwoord;
    @Column(name = "naam")
    private String naam;
    @Column(name = "voornaam")
    private String voornaam;
    @Column(name = "telefoonNummer")
    private String telefoonNummer;
    @Column(name = "land")
    private String land;
    @Column(name = "adres")
    private String adres;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "gemeente")
    private String gemeente;

    @ManyToOne
    private GebruikersType gebruikersType;

    //getters, setters
    public int getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(int gebruikerID) {
        this.gebruikerID = gebruikerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWacthwoord() {
        return wacthwoord;
    }

    public void setWacthwoord(String wacthwoord) {
        this.wacthwoord = wacthwoord;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public GebruikersType getGebruikersType() {
        return gebruikersType;
    }

    public void setGebruikersType(GebruikersType gebruikersType) {
        this.gebruikersType = gebruikersType;
    }
}
