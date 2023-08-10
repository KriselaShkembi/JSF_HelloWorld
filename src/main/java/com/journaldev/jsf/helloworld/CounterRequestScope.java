package com.journaldev.jsf.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "counterRequestScope")
@RequestScoped
public class CounterRequestScope {

    private int value = 0;

    public String increment(){
        value++;
        return "increment";
    }

    public CounterRequestScope() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
