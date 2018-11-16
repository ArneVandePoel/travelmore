package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReisController {
    @Inject
    private ReisService reisService;

    //reis voor op detailpagina
    private Reis reis;

    //reis ophalen
    public Reis getReis(){
        return this.reis;
    }

    public List<Reis> getReizen() {
        return this.reisService.findAllReizen();
    }

    public  String[] getExtras(int id){
        Reis reis = this.reisService.findReis(id);
        String[] extras = reis.getHotel().getExtra().split(";");
        return extras;
    }

    public String getReisDetail(int id){
        this.reis = this.reisService.findReis(id);

        return "detail?faces-redirect=true";
    }
}
