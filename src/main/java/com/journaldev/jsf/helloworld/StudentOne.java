package com.journaldev.jsf.helloworld;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentOne")
public class StudentOne {

    private String firstName;
    private String lastName;
    private String country;
    private List<String> countryOptions;
    private String favoriteLanguage;
    private String[] favouriteSubjects;
    private String email;
    private int freePasses;
    private String postalCode;
    private String phoneNumber;
    private String courseCode;

    public StudentOne() {
        countryOptions = new ArrayList<>();
        countryOptions.add("Brazil");
        countryOptions.add("Albania");
        countryOptions.add("France");
        countryOptions.add("India");

//        firstName = "Pito";
//        lastName = "Pito";
//        favoriteLanguage = "Java";
//        country = "Albania";
    }

    public StudentOne(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void validateTheCourseCode(FacesContext context,
                                      UIComponent component,
                                      Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        String data = value.toString();
        if (!data.startsWith("LUV")) {
            FacesMessage message = new FacesMessage("Course code must start with LUV");
            throw new ValidatorException(message);
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(List<String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getFavouriteSubjects() {
        return favouriteSubjects;
    }

    public void setFavouriteSubjects(String[] favouriteSubjects) {
        this.favouriteSubjects = favouriteSubjects;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
