package com.journaldev.jsf.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "counterSessionScope")
@SessionScoped
public class CounterSessionScope {

    private int value = 0;

    public String increment(){
        value++;
        return "increment";
    }

    public CounterSessionScope() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
