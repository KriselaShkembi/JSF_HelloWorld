package com.journaldev.jsf.helloworld;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "tour")
public class Tour {

    private String kindOFTour;

    public Tour() {
    }

    public String getKindOFTour() {
        return kindOFTour;
    }

    public void setKindOFTour(String kindOFTour) {
        this.kindOFTour = kindOFTour;
    }

    public String startTheTour() {
        if (kindOFTour != null && kindOFTour.equals("city")){
            return "city_tour";
        }
        return "country_tour";
    }

}
