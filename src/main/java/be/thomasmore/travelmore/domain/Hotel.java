package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

    //attributen
    @Id
    private int hotelID;
    @Column(name = "naam")
    private String naam;
    @Column(name = "land")
    private String land;
    @Column(name = "adres")
    private String adres;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "gemeente")
    private String gemeente;
    @Column(name = "telefoonNummer")
    private String telefoonNummer;
    @Column(name = "aantalSterren")
    private int aantalSterren;
    @Column(name = "extra")
    private String extra;

    //getters, setters
    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public int getAantalSterren() {
        return aantalSterren;
    }

    public void setAantalSterren(int aantalSterren) {
        this.aantalSterren = aantalSterren;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
