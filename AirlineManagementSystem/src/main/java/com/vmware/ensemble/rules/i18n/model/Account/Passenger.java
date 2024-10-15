package com.vmware.ensemble.rules.i18n.model.Account;

public class Passenger {

    private String passengerId;
    private String passengerName;
    private long age;
    private String passengerEmail;

    public Passenger(String passengerId, String passengerName, long age, String passengerEmail) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public long getAge() {
        return age;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }
}
