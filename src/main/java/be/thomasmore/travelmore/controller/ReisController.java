package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class ReisController {
    @Inject
    private ReisService reisService;
    private Reis reisobject = new Reis();
    private List<Reis> reisList;

    //reis voor op detailpagina
    private Reis reis;

    //reis ophalen
    public Reis getReis(){
        return this.reis;
    }

    public List<Reis> getReizen() {
        return this.reisService.findAllReizen();
    }

    public List<Reis> getReizenLijst(){
        if(reisList == null)
            reisList = reisService.findAllReizen();
        return reisList;
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }


    public  String[] getExtras(int id){
        Reis reis = this.reisService.findReis(id);
        String[] extras = reis.getHotel().getExtra().split(";");
        return extras;
    }

    public void setReis(Reis reis){
        this.reisobject = reis;
        this.reis = reis;
    }

    public Reis getCurrentReis(){
        return reisobject;
    }

    public String ReisDetails(Reis reis){
        //reis opvullen...
        setReis(reis);

        //ga naar detail pagina
        return "detail";
    }
}
