package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaling;
import be.thomasmore.travelmore.domain.BetalingsMethoden;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.service.BetalingService;
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
    @Inject
    private BetalingService betalingService;

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
        Betaling betaling = new Betaling();
        BetalingsMethoden betalingsMethode = betalingsMethodenService.findBetalingsMethode(betalingsMethodeID);

        betaling.setBoeking(this.boeking);
        betaling.setBetalingsMethode(betalingsMethode);
        betalingService.insert(betaling);

        this.boeking.setBetaald(true);
        this.boeking.setBetaling(betaling);
        boekingService.update(this.boeking);

        return "boekingen";
    }
}
