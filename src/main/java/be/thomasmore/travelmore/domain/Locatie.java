package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name="locatie")
@NamedQueries(
        {
                @NamedQuery(
                        name = Locatie.FIND_ALL,
                        query = "SELECT l FROM Locatie l"
                )
        }
)
public class Locatie {
    public static final String FIND_ALL = "Locatie.findAll";

    //attributen
    @Id
    private int locatieID;
    @Column(name = "land")
    private String land;
    @Column(name = "adres")
    private String adres;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "gemeente")
    private String gemeente;

    //getters, setters
    public int getId() {
        return locatieID;
    }

    public void setId(int id) {
        this.locatieID = id;
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
}
