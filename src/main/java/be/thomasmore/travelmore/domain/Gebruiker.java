package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "gebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_MAIL,
                        query = "SELECT g FROM Gebruiker g WHERE (g.email) = :email"
                )
        }
)
public class Gebruiker {
    public static final String FIND_MAIL = "Gebruiker.findMail";

    //attributen
    @Id
    private int gebruikerID;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;
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
    @Column(name = "salt")
    private String salt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gebruikersTypeID")
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

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wacthwoord) {
        this.wachtwoord = wacthwoord;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public GebruikersType getGebruikersType() {
        return gebruikersType;
    }

    public void setGebruikersType(GebruikersType gebruikersType) {
        this.gebruikersType = gebruikersType;
    }
}
