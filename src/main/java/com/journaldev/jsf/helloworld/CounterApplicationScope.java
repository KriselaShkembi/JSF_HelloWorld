package com.journaldev.jsf.helloworld;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "counterApplicationScope")
@ApplicationScoped
public class CounterApplicationScope {

    private int value = 0;

    public String increment(){
        value++;
        return "increment";
    }

    public CounterApplicationScope() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
