package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.BetalingsMethoden;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.mail.MessagingException;
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
    private int maxAantal;
    private int reisID;
    private String message;

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

    public String getMessage() { return this.message; }

    public List getBoekingenGebruiker(int gebruikerID){
        return this.boekingService.findByGebruiker(gebruikerID);
    }

    public String maakBoekingVoorstel(int reisID, int aantal) {
        System.out.println("hallo?");
        Reis reis = this.reisService.findReis(reisID);

        //checken of er nog plaats is
        int maxAantal = getMaxAantalVoorReis(reis);
        int reisAantal = getAantalVoorReis(reis);

        if((reisAantal + aantal) > maxAantal){
            this.message = "Sorry, er zijn niet genoeg plaatsen meer vrij op deze reis. Aantal vrije plaatsen: " + (maxAantal - reisAantal);

            return "detail";
        }else{
            this.message = null;
            this.prijs = aantal * reis.getPrijs();
            this.aantal = aantal;
            this.reisID = reisID;

            return "detail?faces-redirect=true";
        }
    }

    public int getAantalVoorReis(Reis reis){
        int aantal = 0;
        List<Boeking> boekingen = boekingService.getAll();

        for(Boeking boeking : boekingen){
            if(boeking.getReis().getReisID() == reis.getReisID()){
                aantal += boeking.getAantalPersonen();
            }
        }

        return aantal;
    }

    public int getMaxAantalVoorReis(Reis reis){
        return reis.getBus().getBusType().getAantalPlaatsen();
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

        String email = gebruiker.getEmail();
        String subject = "Bevestiging boeking " + reis.getTitel();
        String message = "Beste " + gebruiker.getVoornaam() + " " + gebruiker.getNaam() + ",<br><br>" +
            "Uw boeking voor de reis " + reis.getTitel() + " voor " + this.aantal +" personen is bevestigd.<br><br>" +
            "Veel plezier in " + reis.getHotel().getLand() + "!<br><br>" +
            "Met vriendelijke groeten,<br><br>" +
            "Het TravelMore team";
        sendMail(email, subject, message);

        this.boekingService.insert(boeking);

        return "boekingen";
    }

    private void sendMail(String email, String subject, String message){
        statusMessage = "Message Sent";
        try {
            MailService.sendMail(email, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
    }

    private String statusMessage = "";
}
