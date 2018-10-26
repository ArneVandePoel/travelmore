package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    @Inject
    private ReisService reisService;

    public List<Reis> getReizen() {
        return this.reisService.findAllReizen();
    }

    public Reis getReis(int id) {return this.reisService.findReis(id);}
}
