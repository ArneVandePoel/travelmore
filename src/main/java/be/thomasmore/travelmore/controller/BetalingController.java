package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.BetalingsMethoden;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.service.BetalingsMethodenService;
import be.thomasmore.travelmore.service.BoekingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class BetalingController {
    @Inject
    private BoekingService boekingService;
    @Inject
    private BetalingsMethodenService betalingsMethodenService;

    private Boeking boeking = new Boeking();
    private List<BetalingsMethoden> betalingsMethoden;

    //getters
    public Boeking getBoeking() {
        return boeking;
    }

    public List<BetalingsMethoden> getBetalingsMethoden() {
        return betalingsMethoden;
    }

    public String betaalPagina(int boekingID){
        this.boeking = boekingService.findBoeking(boekingID);
        this.betalingsMethoden = betalingsMethodenService.findAll();

        return "betalen";
    }

    public String betaalBoeking(int betalingsMethodeID){
        BetalingsMethoden betalingsMethode = betalingsMethodenService.findBetalingsMethode(betalingsMethodeID);

        this.boeking.setBetaald(true);
        this.boeking.setBetalingsMethode(betalingsMethode);
        boekingService.update(this.boeking);

        return "boekingen?faces-redirect=true";
    }
}
