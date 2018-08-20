package com.example.ajitg.allpayhere;

public class ServiceOptions {

    public String personNameText;
    public String personId;
    public String serviceProvides;
    public int imageOfPerson;

    public ServiceOptions(String personNameText, String personId, String serviceProvides, int imageOfPerson) {
        this.personNameText = personNameText;
        this.personId = personId;
        this.serviceProvides = serviceProvides;
        this.imageOfPerson = imageOfPerson;
    }

    public String getPersonNameText() {
        return personNameText;
    }

    public void setPersonNameText(String personNameText) {
        this.personNameText = personNameText;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getServiceProvides() {
        return serviceProvides;
    }

    public void setServiceProvides(String serviceProvides) {
        this.serviceProvides = serviceProvides;
    }

    public int getImageOfPerson() {
        return imageOfPerson;
    }

    public void setImageOfPerson(int imageOfPerson) {
        this.imageOfPerson = imageOfPerson;
    }
}
