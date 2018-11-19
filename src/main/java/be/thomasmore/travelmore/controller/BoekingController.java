package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.BetalingsMethoden;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BetalingsMethodenService;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class BoekingController {
    @Inject
    private BoekingService boekingService;
    @Inject
    private ReisService reisService;
    @Inject
    private GebruikerService gebruikerService;
    @Inject
    private BetalingsMethodenService betalingsMethodenService;

    //variabelen
    private double prijs;
    private int aantal;
    private int reisID;

    //getters
    public double getPrijs() {
        return this.prijs;
    }

    public int getAantal() {
        return this.aantal;
    }

    public int getReisID() {
        return this.reisID;
    }

    public List getBoekingenGebruiker(int gebruikerID){
        return this.boekingService.findByGebruiker(gebruikerID);
    }

    public String maakBoekingVoorstel(int reisID, int aantal) {
        System.out.println("hallo?");
        Reis reis = this.reisService.findReis(reisID);

        this.prijs = aantal * reis.getPrijs();
        this.aantal = aantal;
        this.reisID = reisID;

        return "detail?faces-redirect=true";
    }

    public String maakBoeking(int reisID, String gebruikerMail) {
        Boeking boeking = new Boeking();

        Reis reis = this.reisService.findReis(reisID);
        boeking.setReis(reis);
        Gebruiker gebruiker = this.gebruikerService.findGebruikerByEmail(gebruikerMail);
        boeking.setGebruiker(gebruiker);
        BetalingsMethoden betalingsMethode = this.betalingsMethodenService.findBetalingsMethode(0);
        boeking.setBetalingsMethode(betalingsMethode);
        boeking.setBedrag(this.prijs);
        boeking.setAantalPersonen(this.aantal);

        System.out.print("test 1: " + reis.getReisID());
        System.out.print("test 2: " + gebruiker.getEmail());

        this.boekingService.insert(boeking);

        return "boekingen";
    }
}
