package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@ManagedBean(name="dtFilterView")
@ViewScoped
public class FilterView implements Serializable {

    private List<Reis> reizen;

    private List<Reis> filteredReizen;

    @ManagedProperty("#{carService}")
    private ReisService service;

    @PostConstruct
    public void init() {
        reizen = service.findAllReizen();
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

    public List<Reis> getReizen() {
        return reizen;
    }

    public List<Reis> getFilteredReizen() {
        return filteredReizen;
    }

    public void setFilteredReizen(List<Reis> filteredReizen) {
        this.filteredReizen = filteredReizen;
    }

    public void setService(ReisService service) {
        this.service = service;
    }
}